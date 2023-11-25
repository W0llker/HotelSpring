package itAcadamy.controller;

import annotation.LoggerAnnotation;
import controller.AmenitiesControllerApi;
import controller.CrudController;
import dto.amenities.AmenitiesRequest;
import dto.amenities.AmenitiesResponse;
import itAcadamy.service.AmenitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.AmenitiesApi;

import java.util.List;

@RestController
@RequestMapping("amenities")
public class AmenitiesController extends CrudController<AmenitiesRequest, AmenitiesResponse> implements AmenitiesControllerApi {
    private final AmenitiesApi amenitiesService;
    @Autowired
    public AmenitiesController(AmenitiesService amenitiesService) {
        super(amenitiesService);
        this.amenitiesService = amenitiesService;
    }

    @Override
    @LoggerAnnotation
    public List<AmenitiesResponse> getAllAmenities(AmenitiesRequest amenitiesRequest) {
        return amenitiesService.getAllAmenitiesByHotel(amenitiesRequest.getHotel().getId());
    }

    @Override
    @LoggerAnnotation
    public List<AmenitiesResponse> getAmenitiesByHotelWithType(AmenitiesRequest amenitiesRequest) {
        return amenitiesService.getAllAmenitiesByHotelWithType(amenitiesRequest.getHotel().getId(),amenitiesRequest.getType());
    }

    @Override
    @LoggerAnnotation
    public List<AmenitiesResponse> getAmenitiesByName(AmenitiesRequest amenitiesRequest) {
        return amenitiesService.getAmenitiesByName(amenitiesRequest.getHotel().getId(),amenitiesRequest.getName());
    }
}
