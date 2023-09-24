package service;

import dto.room.RoomRequest;
import dto.room.RoomResponse;
import entity.Room;
import mapper.MapperEntity;
import mapper.RoomMapper;
import repository.HotelDao;
import repository.RoomDao;

public class RoomService implements RoomApi{
    private final RoomDao roomDao;
    private final HotelDao hotelDao;
    private final MapperEntity<Room, RoomRequest, RoomResponse> mapper;

    public RoomService(RoomDao roomDao, HotelDao hotelDao, MapperEntity<Room, RoomRequest, RoomResponse> mapper) {
        this.roomDao = roomDao;
        this.hotelDao = hotelDao;
        this.mapper = mapper;
    }

    @Override
    public void add(Long hotel_id, RoomRequest roomRequest) {
        Room room = mapper.createEntity(roomRequest);
        room.setHotel(hotelDao.findById(hotel_id));
        roomDao.add(room);
    }

    @Override
    public void delete(Long id) {
        roomDao.delete(id);
    }

    @Override
    public void update(Long id, RoomRequest roomRequest) {
        roomDao.update(id,mapper.createEntity(roomRequest));
    }

    @Override
    public RoomResponse findById(Long id) {
        return mapper.createResponse(roomDao.findById(id));
    }
}
