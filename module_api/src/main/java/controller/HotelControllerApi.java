package controller;

import dto.image.ImageRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.awt.*;
import java.math.BigDecimal;

public interface HotelControllerApi {
    @PostMapping("addImage")
    void addImageInHotel(@RequestBody @Valid ImageRequest imageRequest);

    @DeleteMapping("deleteImage")
    void deleteImageInHotel(@RequestBody ImageRequest imageRequest);
}
