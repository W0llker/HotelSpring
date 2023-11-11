package controller;

import dto.DeleteOrFindDto;
import dto.feedback.FeedBackRequest;
import dto.feedback.FeedBackResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface FeedBackControllerApi {
    @PostMapping("getAll")
    List<FeedBackResponse> getFeedBackInHotel(@RequestBody DeleteOrFindDto dto);

    @PostMapping("findStars")
    List<FeedBackResponse> getFeedBackInHotelStars(@RequestBody FeedBackRequest feedBackRequest);

    @PostMapping("findUser")
    List<FeedBackResponse> getFeedBackInHotelUser(@RequestBody FeedBackRequest feedBackRequest, @RequestBody DeleteOrFindDto dto);
}
