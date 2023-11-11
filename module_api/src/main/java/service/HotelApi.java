package service;

import dto.DeleteOrFindDto;
import dto.client.ClientRequest;
import dto.client.ClientResponse;
import dto.hotel.HotelRequest;
import dto.hotel.HotelResponse;
import dto.image.ImageRequest;
import dto.order.OrderRequest;
import dto.order.OrderResponse;
import dto.room.RoomType;

import java.math.BigDecimal;
import java.net.URL;

public interface HotelApi {
    void addImageHotel(ImageRequest imageRequest);

    void deleteImageHotel(ImageRequest imageRequest);

}
