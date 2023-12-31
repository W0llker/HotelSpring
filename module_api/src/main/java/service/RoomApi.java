package service;


import dto.order.OrderRequest;
import dto.room.RoomRequest;
import dto.room.RoomResponse;


import java.util.List;

public interface RoomApi {
    List<RoomResponse> getRoomByType(RoomRequest roomRequest);
    List<RoomResponse> getRoomNotIncludedIds(OrderRequest orderRequest);
}
