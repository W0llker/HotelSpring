package service;


import dto.room.RoomRequest;
import dto.room.RoomResponse;

public interface RoomApi {
    void add(Long hotel_id, RoomRequest roomRequest);
    void delete(Long id);
    void update(Long id, RoomRequest roomRequest);
    RoomResponse findById(Long id);
}
