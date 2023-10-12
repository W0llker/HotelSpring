package mapper;

import dto.room.RoomRequest;
import dto.room.RoomResponse;
import entity.Room;
import entity.RoomType;

public class RoomMapper implements MapperEntity<Room, RoomRequest, RoomResponse>{
    @Override
    public Room createEntity(RoomRequest roomRequest) {
        Room room = new Room();
        room.setRoomType(RoomType.ONE);
        room.setPrice(roomRequest.getPrice());
        room.setFloor(roomRequest.getFloor());
        room.setNumber(roomRequest.getNumber());
        return room;
    }

    @Override
    public RoomResponse createResponse(Room room) {
        return null;
    }
}
