package service;

import dto.amenities.AmenitiesRequest;
import dto.amenities.AmenitiesResponse;
import dto.amenities.AmenitiesType;

import java.util.List;

public interface AmenitiesApi {
    List<AmenitiesResponse> getAllAmenitiesByHotel(Long idHotel);

    List<AmenitiesResponse> getAllAmenitiesByHotelWithType(Long idHotel, AmenitiesType amenitiesType);

    List<AmenitiesResponse> getAmenitiesByName(Long idHotel, String name);
}
