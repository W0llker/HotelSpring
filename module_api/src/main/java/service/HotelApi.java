package service;

import dto.hotel.HotelRequest;
import dto.hotel.HotelResponse;

public interface HotelApi {
    void add(HotelRequest hotelRequest);

    void delete(Long id);

    HotelResponse findById(Long id);

    void update(Long id, HotelRequest hotelRequest);
}
