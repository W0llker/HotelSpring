package itAcadamy.controller;

import controller.CrudController;
import controller.RoomControllerApi;
import dto.order.OrderRequest;
import dto.room.RoomRequest;
import dto.room.RoomResponse;
import itAcadamy.entity.Room;
import itAcadamy.service.RoomService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.RoomApi;

import java.util.List;
@RestController
@RequestMapping("room")
public class RoomController extends CrudController<Room, RoomRequest, RoomResponse> implements RoomControllerApi {
    private final RoomApi roomApi;
    public RoomController(RoomService roomApi) {
        super(roomApi);
        this.roomApi = roomApi;
    }

    @Override
    public List<RoomResponse> getRoomByType(RoomRequest roomRequest) {
        return roomApi.getRoomByType(roomRequest);
    }

    @Override
    public List<RoomResponse> findFreeRoom(OrderRequest orderRequest, RoomRequest roomRequest) {
        return roomApi.getRoomNotIncludedIds(orderRequest,roomRequest);
    }
}
