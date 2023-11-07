package itAcadamy.repository;

import itAcadamy.entity.Amenities;
import itAcadamy.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelDao extends JpaRepository<Hotel,Long> {
}
