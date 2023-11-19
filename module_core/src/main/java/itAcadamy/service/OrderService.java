package itAcadamy.service;

import dto.DeleteOrFindDto;
import dto.amenities.AmenitiesRequest;
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
import itAcadamy.repository.AmenitiesDao;
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
public class OrderService extends CrudService<OrderHotel, OrderRequest, OrderResponse> implements OrderApi {
    private final OrderDao orderDao;
    private final RoomDao roomDao;
    private final ClientDao clientDao;
    private final AmenitiesDao amenitiesDao;
    private final OrderMapper orderMapper;
    private final AmenitiesMapper amenitiesMapper;
    private final EmailService emailService;

    @Autowired
    public OrderService(OrderDao orderDao, RoomDao roomDao, ClientDao clientDao, OrderMapper orderMapper,
                        AmenitiesMapper amenitiesMapper, EmailService emailService, AmenitiesDao amenitiesDao) {
        super(orderMapper, orderDao);
        this.orderDao = orderDao;
        this.roomDao = roomDao;
        this.clientDao = clientDao;
        this.orderMapper = orderMapper;
        this.amenitiesMapper = amenitiesMapper;
        this.emailService = emailService;
        this.amenitiesDao = amenitiesDao;
    }

    @Override
    public List<OrderResponse> getAllOrderByHotel(Long idHotel) {
        return orderDao.getAllOrderByHotelId(idHotel).stream().map(orderMapper::createResponse).collect(Collectors.toList());
    }

    @Override
    public List<OrderResponse> getAllOrderByClient(Long idClient) {
        return orderDao.getAllOrderByClientId(idClient).stream().map(orderMapper::createResponse).collect(Collectors.toList());
    }

    @Override
    public OrderResponse update(OrderRequest orderRequest) {
        OrderHotel order = Optional.of(orderDao.findById(orderRequest.getId()).orElseThrow(() -> new OrderException("Нету такого ордера"))).get();
        if (order.getOrderType().equals(OrderType.NO)) {
            return orderMapper.createResponse(orderSave(orderRequest));
        }
        throw new OrderException("На данный момент невозможно сделать эту операцию");
    }

    private OrderHotel orderSave(OrderRequest orderRequest) {
        List<Room> roomsFree = getRoomsFree(orderRequest, orderRequest.getRoomType());
        if (roomsFree.size() == 0) throw new RuntimeException("Все комнаты заняты");
        OrderHotel orderHotel = createOrder(orderRequest);
        orderHotel.setRoom(roomsFree.get(0));
        if (orderRequest.getAmenities() != null) {
            orderHotel.setAmenities(amenitiesDao.getAmenitiesByIdsWithHotel(orderRequest.getAmenities().stream().map(AmenitiesRequest::getId).collect(Collectors.toList()), orderRequest.getHotel().getId()));
        }
        orderHotel.setPrice(getCost(orderHotel));
        orderDao.save(orderHotel);
        return orderHotel;
    }

    @Override
    @Transactional
    public OrderResponse orderFormation(OrderRequest orderRequest) {
        OrderHotel order = orderSave(orderRequest);
        return orderMapper.createResponse(order);
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
    @Scheduled(fixedRate = 150000)
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
