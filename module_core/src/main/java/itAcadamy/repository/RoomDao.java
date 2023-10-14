package itAcadamy.repository;

import itAcadamy.entity.Room;
import dto.room.RoomType;

import java.util.List;

public interface RoomDao {
    void add(Room room);

    void delete(Long id);

    void update(Long id, Room room);

    List<Room> getRoomByType(Long hotelId, RoomType roomType);

    List<Room> getRoomNotIncludedIds(List<Long> rooms, RoomType roomType, Long hotelId);

    Room findById(Long id);
}
