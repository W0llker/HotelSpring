package itAcadamy.mapper;

import dto.room.RoomRequest;
import dto.room.RoomResponse;
import itAcadamy.entity.Room;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomMapper {
    Room createEntity(RoomRequest roomRequest);
    RoomResponse createResponse(Room room);
}
