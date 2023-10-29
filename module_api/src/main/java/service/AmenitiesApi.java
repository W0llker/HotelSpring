package service;

import dto.amenities.AmenitiesRequest;
import dto.amenities.AmenitiesResponse;
import dto.amenities.AmenitiesType;

import java.util.List;

public interface AmenitiesApi {
    void addAmenities(Long idHotel, AmenitiesRequest amenitiesRequest);

    AmenitiesResponse findAmenitiesById(Long idAmenities);

    List<AmenitiesResponse> getAllAmenitiesByHotel(Long idHotel);

    List<AmenitiesResponse> getAllAmenitiesByHotelWithType(Long idHotel, AmenitiesType amenitiesType);

    void deleteAmenities(Long idAmenities);

    void updateAmenities(AmenitiesRequest amenitiesRequest);
}
