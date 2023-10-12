package repository;

import entity.Client;
import entity.Room;
import entity.RoomType;

import java.util.List;

public interface RoomDao {
    void add(Room room);

    void delete(Long id);

    void update(Long id,Room room);
    List<Room> getRoomByType(Long hotelId, RoomType roomType);

    Room findById(Long id);
}
