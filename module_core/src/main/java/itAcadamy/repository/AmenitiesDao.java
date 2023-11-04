package itAcadamy.repository;

import itAcadamy.entity.Amenities;
import dto.amenities.AmenitiesType;

import java.util.List;

public interface AmenitiesDao extends CrudOperation<Amenities> {
    List<Amenities> getAmenitiesByName(Long idHotel, String name);

    List<Amenities> getAmenitiesType(Long idHotel, AmenitiesType amenitiesType);

    List<Amenities> getAmenities(Long idHotel);
}
