package itAcadamy.controller;

import controller.CrudController;
import controller.HotelControllerApi;
import dto.DeleteOrFindDto;
import dto.hotel.HotelRequest;
import dto.hotel.HotelResponse;
import dto.image.ImageRequest;
import dto.order.OrderRequest;
import dto.order.OrderResponse;
import itAcadamy.entity.Hotel;
import itAcadamy.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.CrudService;
import service.HotelApi;

import java.math.BigDecimal;

@RestController
@RequestMapping("hotel")
public class HotelController extends CrudController<Hotel, HotelRequest, HotelResponse> implements HotelControllerApi {
    private final HotelApi hotelApi;
    @Autowired
    public HotelController(HotelService hotelApi) {
        super(hotelApi);
        this.hotelApi = hotelApi;
    }

    @Override
    public void addImageInHotel(ImageRequest imageRequest) {
        hotelApi.addImageHotel(imageRequest);
    }

    @Override
    public void deleteImageInHotel(ImageRequest imageRequest) {
        hotelApi.deleteImageHotel(imageRequest);
    }

}
