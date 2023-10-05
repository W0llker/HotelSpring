package mapper;

import dto.hotel.HotelRequest;
import dto.hotel.HotelResponse;
import entity.Hotel;

public class HotelMapper implements MapperEntity<Hotel, HotelRequest, HotelResponse>{
    @Override
    public Hotel createEntity(HotelRequest hotelRequest) {
        return null;
    }

    @Override
    public HotelResponse createResponse(Hotel hotel) {
        return null;
    }
}
