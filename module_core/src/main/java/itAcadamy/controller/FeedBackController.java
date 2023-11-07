package itAcadamy.controller;

import controller.CrudController;
import controller.FeedBackControllerApi;
import dto.DeleteOrFindDto;
import dto.feedback.FeedBackRequest;
import dto.feedback.FeedBackResponse;
import itAcadamy.entity.FeedBack;
import itAcadamy.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.FeedBackApi;

import java.util.List;

@RestController
@RequestMapping("feedback")
public class FeedBackController extends CrudController<FeedBack, FeedBackRequest, FeedBackResponse> implements FeedBackControllerApi {
    private final FeedBackApi feedBackApi;
    @Autowired
    public FeedBackController(FeedBackService feedBackApi) {
        super(feedBackApi);
        this.feedBackApi = feedBackApi;
    }

    @Override
    public List<FeedBackResponse> getFeedBackInHotel(DeleteOrFindDto dto) {
        return feedBackApi.getFeedBackInHotel(dto);
    }

    @Override
    public List<FeedBackResponse> getFeedBackInHotelStars(FeedBackRequest feedBackRequest) {
        return feedBackApi.getFeedBackInHotelStars(feedBackRequest);
    }

    @Override
    public List<FeedBackResponse> getFeedBackInHotelUser(FeedBackRequest feedBackRequest, DeleteOrFindDto dto) {
        return feedBackApi.getFeedBackInHotelUser(feedBackRequest,dto);
    }
}
