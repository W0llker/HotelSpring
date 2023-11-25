package itAcadamy.service;

import dto.order.OrderRequest;
import dto.room.RoomRequest;
import dto.room.RoomResponse;
import itAcadamy.entity.Room;
import itAcadamy.mapper.RoomMapper;
import itAcadamy.repository.OrderDao;
import itAcadamy.repository.RoomDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSException;
import service.CrudService;
import service.RoomApi;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService extends CrudService<Room, RoomRequest, RoomResponse> implements RoomApi {
    private final RoomDao roomDao;
    private final OrderDao orderDao;

    private final RoomMapper roomMapper;

    @Autowired
    public RoomService(RoomDao roomDao, RoomMapper roomMapper, OrderDao orderDao) {
        super(roomMapper, roomDao);
        this.roomDao = roomDao;
        this.roomMapper = roomMapper;
        this.orderDao = orderDao;
    }

    @Override
    public List<RoomResponse> getRoomByType(RoomRequest roomRequest) {
        return roomDao.getRoomByType(roomRequest.getHotel().getId(), roomRequest.getRoomType()).stream().map(roomMapper::createResponse).collect(Collectors.toList());
    }

    @Override
    public List<RoomResponse> getRoomNotIncludedIds(OrderRequest orderRequest) {
        List<Long> longList = orderDao.getOrderInTheData(orderRequest.getRoomType(), orderRequest.getDateStart(), orderRequest.getDateEnd());
        longList.add(0L);
        List<Room> rooms = roomDao.getRoomNotIncludedIds(longList,orderRequest.getRoomType(), orderRequest.getHotel().getId());
        return rooms.stream().map(roomMapper::createResponse).collect(Collectors.toList());
    }
}
