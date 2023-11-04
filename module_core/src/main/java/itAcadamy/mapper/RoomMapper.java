package itAcadamy.mapper;

import dto.order.OrderRequest;
import dto.order.OrderResponse;
import dto.room.RoomRequest;
import dto.room.RoomResponse;
import itAcadamy.entity.OrderHotel;
import itAcadamy.entity.Room;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomMapper extends SupperMapper<Room, RoomRequest, RoomResponse>{
}
