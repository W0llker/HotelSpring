package itAcadamy.controller;

import annotation.LoggerAnnotation;
import controller.CrudController;
import controller.RoomControllerApi;
import dto.order.OrderRequest;
import dto.room.RoomRequest;
import dto.room.RoomResponse;
import itAcadamy.service.RoomService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.RoomApi;

import java.util.List;
@RestController
@RequestMapping("room")
public class RoomController extends CrudController<RoomRequest, RoomResponse> implements RoomControllerApi {
    private final RoomApi roomApi;
    public RoomController(RoomService roomApi) {
        super(roomApi);
        this.roomApi = roomApi;
    }

    @Override
    @LoggerAnnotation
    public List<RoomResponse> getRoomByType(RoomRequest roomRequest) {
        return roomApi.getRoomByType(roomRequest);
    }

    @Override
    @LoggerAnnotation
    public List<RoomResponse> findFreeRoom(OrderRequest orderRequest) {
        return roomApi.getRoomNotIncludedIds(orderRequest);
    }
}
