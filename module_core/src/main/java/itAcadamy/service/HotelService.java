package itAcadamy.service;

import dto.hotel.HotelRequest;
import dto.hotel.HotelResponse;
import dto.order.OrderRequest;
import dto.order.OrderResponse;
import dto.room.RoomType;
import itAcadamy.entity.Hotel;
import itAcadamy.entity.ImageHotel;
import itAcadamy.entity.OrderHotel;
import itAcadamy.entity.Room;
import itAcadamy.mapper.HotelMapper;
import itAcadamy.mapper.OrderMapper;
import itAcadamy.repository.OrderDao;
import itAcadamy.repository.RoomDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import itAcadamy.repository.HotelDao;
import service.HotelApi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelService implements HotelApi {

    private final HotelDao hotelDao;
    private final RoomDao roomDao;
    private final OrderDao orderDao;
    private final HotelMapper mapper;
    private final OrderMapper orderMapper;

    @Override
    public void add(HotelRequest hotelRequest) {
        hotelDao.add(mapper.createEntity(hotelRequest));
    }

    @Override
    public void addImageHotel(Long hotelId, String name, String urlImage) {
        Hotel hotel = hotelDao.findById(hotelId);
        if (hotel == null) {
            throw new RuntimeException();
        }
        // TODO: 14.10.2023 Придумать проверку по имени файла (вроде работает, но не точно)
        if (hotel.getImage().size() > 0)
            hotel.getImage().stream().filter(imageHotel -> !imageHotel.getName().equals(name))
                    .findAny().orElseThrow();
        try {
            hotel.getImage().add(new ImageHotel(name, Files.readAllBytes(Paths.get(urlImage))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        hotelDao.update(hotelId, hotel);
    }

    @Override
    public void deleteImageHotel(Long hotelId, String name) {

    }

    @Override
    public OrderResponse bookRoom(OrderRequest orderRequest, RoomType roomType) {
        List<Long> roomsIdBusy = orderDao.getOrderInTheData(roomType, orderRequest.getStart(), orderRequest.getEnd());
        List<Room> roomsFree = roomDao.getRoomNotIncludedIds(roomsIdBusy, roomType, orderRequest.getHotelId());

        if (roomsFree.size() == 0) throw new RuntimeException("Все комнаты заняты");
        // TODO: 14.10.2023 Создать ордер
        OrderHotel hotel = orderMapper.createEntity(orderRequest);
        return null;
    }

    @Override
    public int createOrder(Long hotelId, Long clientId) {
        // TODO: 14.10.2023 ордер для Администратора
        return 0;
    }

    @Override
    public void delete(Long id) {
        hotelDao.delete(id);
    }

    @Override
    public HotelResponse findById(Long id) {
        return mapper.createResponse(hotelDao.findById(id));
    }

    @Override
    public void update(Long id, HotelRequest hotelRequest) {
        hotelDao.update(id, mapper.createEntity(hotelRequest));
    }
}
