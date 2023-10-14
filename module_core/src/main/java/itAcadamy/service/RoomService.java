package itAcadamy.service;

import dto.room.RoomRequest;
import dto.room.RoomResponse;
import itAcadamy.entity.Room;
import itAcadamy.mapper.RoomMapper;
import itAcadamy.repository.RoomDao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import itAcadamy.repository.HotelDao;
import service.RoomApi;

@Service
@RequiredArgsConstructor
public class RoomService implements RoomApi {

    private final RoomDao roomDao;

    private final HotelDao hotelDao;

    private final RoomMapper roomMapper;


    @Override
    public void add(Long hotel_id, RoomRequest roomRequest) {
        Room room = roomMapper.createEntity(roomRequest);
        room.setHotel(hotelDao.findById(hotel_id));
        roomDao.add(room);
    }

    @Override
    public void delete(Long id) {
        roomDao.delete(id);
    }

    @Override
    public void update(Long id, RoomRequest roomRequest) {
        roomDao.update(id, roomMapper.createEntity(roomRequest));
    }

    @Override
    public RoomResponse findById(Long id) {
        return roomMapper.createResponse(roomDao.findById(id));
    }
}
