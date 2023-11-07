package itAcadamy.mapper;

import dto.room.RoomRequest;
import dto.room.RoomResponse;
import itAcadamy.entity.Room;
import mapper.SupperMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomMapper extends SupperMapper<Room, RoomRequest, RoomResponse> {
}
