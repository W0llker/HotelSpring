package itAcadamy.service;

import dto.room.RoomRequest;
import dto.room.RoomResponse;
import itAcadamy.aspect.CustomTransaction;
import itAcadamy.entity.Hotel;
import itAcadamy.entity.Room;
import itAcadamy.mapper.RoomMapper;
import itAcadamy.repository.RoomDao;
import jakarta.transaction.Transactional;
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
    @CustomTransaction
    public void add(Long hotel_id, RoomRequest roomRequest) {
        Room room = roomMapper.createEntity(roomRequest);
        room.setHotel(hotelDao.findById(hotel_id, Hotel.class));
        roomDao.add(room);
    }

    @Override
    @CustomTransaction
    public void update(Long id, RoomRequest roomRequest) {
        roomDao.update(roomMapper.createEntity(roomRequest));
    }

    @Override
    @CustomTransaction
    public RoomResponse findById(Long id) {
        return roomMapper.createResponse(roomDao.findById(id, Room.class));
    }

    @Override
    @CustomTransaction
    public void delete(RoomRequest roomRequest) {
        roomDao.delete(roomMapper.createEntity(roomRequest));
    }
}
