package itAcadamy.repository;

import itAcadamy.entity.Amenities;
import dto.amenities.AmenitiesType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AmenitiesDao extends JpaRepository<Amenities,Long> {
    @Query("select a from Amenities a where a.hotel.id=:idHotel and a.name=:name")
    List<Amenities> getAmenitiesByName(Long idHotel, String name);
    @Query("select a from Amenities a where a.hotel.id=:idHotel and a.type=:amenitiesType")
    List<Amenities> getAmenitiesType(Long idHotel, AmenitiesType amenitiesType);
    @Query("select a from Amenities a where a.hotel.id=:idHotel")
    List<Amenities> getAmenities(Long idHotel);
    @Query("select a from Amenities a where a.hotel.id=:idHotel and a.id in(:idAmenities)")
    List<Amenities> getAmenitiesByIdsWithHotel(List<Long> idAmenities,Long idHotel);
}
