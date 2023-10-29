package itAcadamy.repository;

import itAcadamy.entity.FeedBack;

import java.util.List;

public interface FeedBackDao extends CrudOperation<FeedBack>{
    List<FeedBack> getFeedBackInHotelStars(Long hotelId, Integer stars);

    List<FeedBack> getFeedBackInHotel(Long hotelId);

    List<FeedBack> getFeedBackInHotelUser(Long hotelId, Long UserId);
}
