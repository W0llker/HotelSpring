package service;

import dto.hotel.HotelRequest;
import dto.hotel.HotelResponse;
import entity.Hotel;
import mapper.MapperEntity;
import repository.HotelDao;

public class HotelService implements HotelApi {
    private final HotelDao hotelDao;
    private final MapperEntity<Hotel, HotelRequest, HotelResponse> mapper;

    public HotelService(HotelDao hotelDao, MapperEntity<Hotel, HotelRequest, HotelResponse> mapper) {
        this.hotelDao = hotelDao;
        this.mapper = mapper;
    }

    @Override
    public void add(HotelRequest hotelRequest) {
        hotelDao.add(mapper.createEntity(hotelRequest));
    }

    @Override
    public void delete(Long id) {
        hotelDao.delete(id);
    }

    @Override
    public HotelResponse findById(Long id) {
        return mapper.createResponse(hotelDao.findById(id));
    }

    @Override
    public void update(Long id, HotelRequest hotelRequest) {
        hotelDao.update(id, mapper.createEntity(hotelRequest));
    }
}
