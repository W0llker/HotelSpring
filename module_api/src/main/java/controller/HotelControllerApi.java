package controller;

import dto.DeleteOrFindDto;
import dto.image.ImageRequest;
import dto.order.OrderRequest;
import dto.order.OrderResponse;
import dto.room.RoomType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.awt.*;
import java.math.BigDecimal;

public interface HotelControllerApi {
    @PostMapping("addImage")
    void addImageInHotel(@RequestBody ImageRequest imageRequest);

    @DeleteMapping("deleteImage")
    void deleteImageInHotel(@RequestBody ImageRequest imageRequest);
}
