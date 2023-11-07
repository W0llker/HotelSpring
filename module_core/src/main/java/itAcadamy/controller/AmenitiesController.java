package itAcadamy.controller;

import controller.AmenitiesControllerApi;
import controller.CrudController;
import dto.amenities.AmenitiesRequest;
import dto.amenities.AmenitiesResponse;
import itAcadamy.entity.Amenities;
import itAcadamy.service.AmenitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.AmenitiesApi;
import service.CrudService;

import java.util.List;

@RestController
@RequestMapping("amenities")
public class AmenitiesController extends CrudController<Amenities, AmenitiesRequest, AmenitiesResponse> implements AmenitiesControllerApi {
    private final AmenitiesApi amenitiesService;
    @Autowired
    public AmenitiesController(AmenitiesService amenitiesService) {
        super(amenitiesService);
        this.amenitiesService = amenitiesService;
    }

    @Override
    public List<AmenitiesResponse> getAllAmenities(AmenitiesRequest amenitiesRequest) {
        return amenitiesService.getAllAmenitiesByHotel(amenitiesRequest.getHotel().getId());
    }

    @Override
    public List<AmenitiesResponse> getAmenitiesByHotelWithType(AmenitiesRequest amenitiesRequest) {
        return amenitiesService.getAllAmenitiesByHotelWithType(amenitiesRequest.getHotel().getId(),amenitiesRequest.getType());
    }

    @Override
    public List<AmenitiesResponse> getAmenitiesByName(AmenitiesRequest amenitiesRequest) {
        return amenitiesService.getAmenitiesByName(amenitiesRequest.getHotel().getId(),amenitiesRequest.getName());
    }
}
