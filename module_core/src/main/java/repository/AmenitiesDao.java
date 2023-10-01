package repository;

import entity.Amenities;
import entity.AmenitiesType;

import java.util.List;

public interface AmenitiesDao {
    void addAmenities(Long idHotel, Amenities amenities);

    void deleteAmenities(Long idHotel, Long idAmenities);

    void update(Long idHotel, Long idAmenities, Amenities amenities);

    List<Amenities> getAmenitiesByName(Long idHotel, String name);

    List<Amenities> getAmenitiesType(Long idHotel, AmenitiesType amenitiesType);

    List<Amenities> getAmenities(Long idHotel);
}
