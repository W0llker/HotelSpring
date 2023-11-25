package controller;

import dto.order.OrderRequest;
import dto.room.RoomRequest;
import dto.room.RoomResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface RoomControllerApi {
    @PostMapping("getRoomType")
    List<RoomResponse> getRoomByType(@RequestBody RoomRequest roomRequest);

    @PostMapping("findFreeRoom")
    List<RoomResponse> findFreeRoom(@RequestBody OrderRequest orderRequest, @RequestBody RoomRequest roomRequest);
}
