package controller;

import dto.amenities.AmenitiesRequest;
import dto.amenities.AmenitiesResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface AmenitiesControllerApi {
    @PostMapping("getAll")
    List<AmenitiesResponse> getAllAmenities(@RequestBody AmenitiesRequest amenitiesRequest);

    @PostMapping("findType")
    List<AmenitiesResponse> getAmenitiesByHotelWithType(@RequestBody AmenitiesRequest amenitiesRequest);

    @PostMapping("findByName")
    List<AmenitiesResponse> getAmenitiesByName(@RequestBody AmenitiesRequest amenitiesRequest);

}
