package itAcadamy.repository;

import itAcadamy.entity.Amenities;
import itAcadamy.entity.Room;
import dto.room.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomDao extends JpaRepository<Room,Long> {
    @Query("select r from Room r where r.hotel.id=:hotelId and r.roomType=:roomType")
    List<Room> getRoomByType(Long hotelId, RoomType roomType);
    @Query("select r from Room r where r.roomType=:roomType and r.hotel.id=:hotelId and r.id not in(:rooms)")
    List<Room> getRoomNotIncludedIds(List<Long> rooms, RoomType roomType, Long hotelId);

}
