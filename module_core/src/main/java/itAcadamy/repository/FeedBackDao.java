package itAcadamy.repository;

import dto.feedback.FeedBackResponse;
import itAcadamy.entity.Amenities;
import itAcadamy.entity.FeedBack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FeedBackDao extends JpaRepository<FeedBack,Long> {
    @Query("select f from FeedBack f where f.hotel.id=:hotelId and f.stars=:stars")
    List<FeedBack> getFeedBackInHotelStars(Long hotelId, Integer stars);
    @Query("select f from FeedBack f where f.hotel.id=:hotelId")
    List<FeedBack> getFeedBackInHotel(Long hotelId);
    @Query("select f from FeedBack f where f.hotel.id=:hotelId and f.orderHotel.client.id=:userId")
    List<FeedBack> getFeedBackInHotelUser(Long hotelId, Long userId);
}
