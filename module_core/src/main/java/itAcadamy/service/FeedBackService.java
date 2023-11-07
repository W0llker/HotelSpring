package itAcadamy.service;

import dto.DeleteOrFindDto;
import dto.feedback.FeedBackRequest;
import dto.feedback.FeedBackResponse;
import itAcadamy.entity.FeedBack;
import itAcadamy.mapper.FeedBackMapper;
import itAcadamy.repository.FeedBackDao;
import mapper.SupperMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import service.CrudService;
import service.FeedBackApi;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedBackService extends CrudService<FeedBack, FeedBackRequest, FeedBackResponse> implements FeedBackApi {
    private final FeedBackDao feedBackDao;
    private final FeedBackMapper feedBackMapper;

    public FeedBackService(FeedBackMapper feedBackMapper, FeedBackDao feedBackDao) {
        super(feedBackMapper, feedBackDao);
        this.feedBackDao = feedBackDao;
        this.feedBackMapper = feedBackMapper;
    }

    @Override
    public List<FeedBackResponse> getFeedBackInHotelStars(FeedBackRequest feedBackRequest) {
        return feedBackDao.getFeedBackInHotelStars(feedBackRequest.getHotel().getId(), feedBackRequest.getStars()).stream().map(feedBackMapper::createResponse).collect(Collectors.toList());
    }

    @Override
    public List<FeedBackResponse> getFeedBackInHotel(DeleteOrFindDto dto) {
        return feedBackDao.getFeedBackInHotel(dto.getId()).stream().map(feedBackMapper::createResponse).collect(Collectors.toList());
    }

    @Override
    public List<FeedBackResponse> getFeedBackInHotelUser(FeedBackRequest feedBackRequest, DeleteOrFindDto dto) {
        return feedBackDao.getFeedBackInHotelUser(feedBackRequest.getHotel().getId(), dto.getId()).stream().map(feedBackMapper::createResponse).collect(Collectors.toList());
    }
}
