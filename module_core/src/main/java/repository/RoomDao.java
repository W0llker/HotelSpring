package repository;

import entity.Client;
import entity.Room;

public interface RoomDao {
    void add(Room room);

    void delete(Long id);

    void update(Long id, Room room);

    Room findById(Long id);
}
