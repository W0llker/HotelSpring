package repository;

import entity.FeedBack;

import java.util.List;

public interface FeedBackDao {
    void add(Long hotelId, FeedBack feedBack);

    void edit(Long hotelId, Long feedBackId, FeedBack feedBack);

    void delete(Long hotelId, Long feedBackId);

    List<FeedBack> getFeedBackInHotelStars(Long hotelId, Integer stars);

    List<FeedBack> getFeedBackInHotel(Long hotelId);

    List<FeedBack> getFeedBackInHotelUser(Long hotelId, Long UserId);
}
