package itAcadamy.controller;

import controller.CrudController;
import controller.HotelControllerApi;
import dto.hotel.HotelRequest;
import dto.hotel.HotelResponse;
import dto.image.ImageRequest;
import itAcadamy.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.HotelApi;

@RestController
@RequestMapping("hotel")
public class HotelController extends CrudController<HotelRequest, HotelResponse> implements HotelControllerApi {
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
