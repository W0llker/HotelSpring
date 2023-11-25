package itAcadamy.service;

import dto.DeleteOrFindDto;
import dto.client.ClientStatus;
import dto.order.OrderRequest;
import dto.order.OrderResponse;
import dto.order.OrderType;
import dto.room.RoomType;
import itAcadamy.entity.Client;
import itAcadamy.entity.OrderHotel;
import itAcadamy.entity.Room;
import itAcadamy.exception.OrderException;
import itAcadamy.mapper.AmenitiesMapper;
import itAcadamy.mapper.OrderMapper;
import itAcadamy.repository.ClientDao;
import itAcadamy.repository.OrderDao;
import itAcadamy.repository.RoomDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import service.CrudService;
import service.OrderApi;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService extends CrudService<OrderHotel,OrderRequest, OrderResponse> implements OrderApi {
    private final OrderDao orderDao;
    private final RoomDao roomDao;
    private final ClientDao clientDao;
    private final OrderMapper orderMapper;
    private final AmenitiesMapper amenitiesMapper;
    private final EmailService emailService;

    @Autowired
    public OrderService(OrderDao orderDao, RoomDao roomDao, ClientDao clientDao, OrderMapper orderMapper,
                        AmenitiesMapper amenitiesMapper, EmailService emailService) {
        super(orderMapper, orderDao);
        this.orderDao = orderDao;
        this.roomDao = roomDao;
        this.clientDao = clientDao;
        this.orderMapper = orderMapper;
        this.amenitiesMapper = amenitiesMapper;
        this.emailService = emailService;
    }

    @Override
    // TODO: 06.11.2023 Переделать на пагинацию
    public List<OrderResponse> getAllOrderByHotel(Long idHotel) {
        return orderDao.getAllOrderByHotelId(idHotel).stream().map(orderMapper::createResponse).collect(Collectors.toList());
    }

    @Override
    public List<OrderResponse> getAllOrderByClient(Long idClient) {
        return orderDao.getAllOrderByClientId(idClient).stream().map(orderMapper::createResponse).collect(Collectors.toList());
    }

    @Override
    public BigDecimal checkFreeRooms(OrderRequest orderRequest) {
        List<Room> roomsFree = getRoomsFree(orderRequest, orderRequest.getRoomType());
        if (roomsFree.size() == 0) throw new RuntimeException("Все комнаты заняты");
        OrderHotel orderHotel = orderMapper.createEntity(orderRequest);
        orderHotel.setRoom(roomsFree.get(0));
        return getCost(orderHotel);
    }

    @Override
    @Transactional
    public OrderResponse orderFormation(OrderRequest orderRequest) {
        List<Room> roomsFree = getRoomsFree(orderRequest, orderRequest.getRoomType());
        if (roomsFree.size() == 0) throw new RuntimeException("Все комнаты заняты");
        OrderHotel order = createOrder(orderRequest);
        order.setRoom(roomsFree.get(0));
        if (orderRequest.getAmenitiesRequestList() != null) {
            order.setAmenities(orderRequest.getAmenitiesRequestList().stream().map(amenitiesMapper::createEntity).collect(Collectors.toList()));
        }
        order.setPrice(getCost(order));
        orderDao.save(order);
        return orderMapper.createResponse(order);
    }

    @Override
    @Transactional
    public void paymentOrder(DeleteOrFindDto dto) {
        OrderHotel orderHotel = Optional.of(orderDao.findById(dto.getId()).orElseThrow(() -> new OrderException("Орден не найден"))).get();
        if (orderHotel.getOrderType() != OrderType.NO)
            throw new OrderException("Ордер оплачен");
        orderHotel.setOrderType(OrderType.PAID);
        orderHotel.setPrice(getCost(orderHotel));
        Client client = orderHotel.getClient();
        client.setMoneySpent(client.getMoneySpent().add(orderHotel.getPrice()));
        updateClient(client);
        orderDao.save(orderHotel);
        emailService.sendOrderToMail(orderHotel);
    }

    @Override
    @Transactional
    public void cancelOrder(DeleteOrFindDto dto) {
        OrderHotel orderHotel = Optional.of(orderDao.findById(dto.getId()).orElseThrow(() -> new OrderException("Орден не найден"))).get();
        if (orderHotel.getOrderType() != OrderType.NO && orderHotel.getOrderType() != OrderType.PAID)
            throw new OrderException("Ордер оплачен и не может быть отменен");
        if (orderHotel.getOrderType().equals(OrderType.PAID)) {
            //типо возвращаю деньги на карту
            Client client = orderHotel.getClient();
            client.setMoneySpent(client.getMoneySpent().subtract(orderHotel.getPrice()));
            updateClient(client);
        }
        orderDao.delete(orderHotel);
    }

    @Override
    @Transactional
    @Scheduled(fixedRate = 15000000)
    public void updateOrder() {
        List<OrderHotel> orderHotels = orderDao.getAllOrderByOrderTypePaidOrPaidAndLife();
        for (OrderHotel orderHotel : orderHotels) {
            if (LocalDate.now().equals(orderHotel.getDateStart()) && !orderHotel.getOrderType().equals(OrderType.PAID_AND_LIFE)) {
                orderHotel.setOrderType(OrderType.PAID_AND_LIFE);
                orderDao.save(orderHotel);
            }
            if (LocalDate.now().equals(orderHotel.getDateEnd())) {
                orderHotel.setOrderType(OrderType.FINISH);
                orderDao.save(orderHotel);
            }
        }
    }

    private List<Room> getRoomsFree(OrderRequest orderRequest, RoomType roomType) {
        List<Long> roomsIdBusy = orderDao.getOrderInTheData(roomType, orderRequest.getDateStart(), orderRequest.getDateEnd());
        roomsIdBusy.add(0L);
        return roomDao.getRoomNotIncludedIds(roomsIdBusy, roomType, orderRequest.getHotel().getId());
    }

    @Transactional
    private void updateClient(Client client) {
        double moneySpent = client.getMoneySpent().doubleValue();
        if (moneySpent < 1000) {
            client.setClientStatus(ClientStatus.NORMAL);
        }
        if (moneySpent > 1000) {
            client.setClientStatus(ClientStatus.STANDART);
        }
        if (moneySpent > 1500) {
            client.setClientStatus(ClientStatus.PREMIUM);
        }
        clientDao.save(client);
    }

    private BigDecimal getCost(OrderHotel orderHotel) {
        BigDecimal priceAllAmenities = new BigDecimal(0);
        int sale = orderHotel.getClient() == null ? 0 : orderHotel.getClient().getClientStatus().getSale();
        if (orderHotel.getAmenities() != null) {
            priceAllAmenities = new BigDecimal(orderHotel.getAmenities().stream().mapToInt(amenities -> (int) amenities.getPrice().doubleValue()).sum());
        }
        long p2 = ChronoUnit.DAYS.between(orderHotel.getDateStart(), orderHotel.getDateEnd());
        BigDecimal priceNotSale = orderHotel.getRoom().getPrice().multiply(new BigDecimal(p2)).add(priceAllAmenities.multiply(new BigDecimal(p2)));
        return priceNotSale.subtract(priceNotSale.divide(new BigDecimal(100)).multiply(new BigDecimal(sale)));
    }

    private OrderHotel createOrder(OrderRequest orderRequest) {
        OrderHotel orderHotel = orderMapper.createEntity(orderRequest);
        orderHotel.setClient(Optional.of(clientDao.findById(orderRequest.getClient().getId()).orElseThrow(() -> new RuntimeException(""))).get());
        orderHotel.setOrderType(OrderType.NO);
        return orderHotel;
    }
}
