package itAcadamy.repository;

import itAcadamy.entity.Room;
import dto.room.RoomType;

import java.util.List;

public interface RoomDao extends CrudOperation<Room> {
    List<Room> getRoomByType(Long hotelId, RoomType roomType);

    List<Room> getRoomNotIncludedIds(List<Long> rooms, RoomType roomType, Long hotelId);

}
