package service;

import dto.hotel.HotelRequest;
import dto.hotel.HotelResponse;
import dto.order.OrderRequest;
import dto.order.OrderResponse;
import dto.room.RoomType;

import java.net.URL;

public interface HotelApi {
    void add(HotelRequest hotelRequest);

    void delete(Long id);

    void addImageHotel(Long hotelId, String name, String urlImage);
    void deleteImageHotel(Long hotelId,String name);
    OrderResponse bookRoom(OrderRequest orderRequest, RoomType roomType);
    int createOrder(Long hotelId,Long clientId);

    HotelResponse findById(Long id);

    void update(Long id, HotelRequest hotelRequest);
}
