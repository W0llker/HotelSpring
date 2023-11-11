package service;

import dto.DeleteOrFindDto;
import dto.feedback.FeedBackRequest;
import dto.feedback.FeedBackResponse;

import java.util.List;

public interface FeedBackApi {
    List<FeedBackResponse> getFeedBackInHotelStars(FeedBackRequest feedBackRequest);
    List<FeedBackResponse> getFeedBackInHotel(DeleteOrFindDto dto);
    List<FeedBackResponse> getFeedBackInHotelUser(FeedBackRequest feedBackRequest, DeleteOrFindDto dto);
}
