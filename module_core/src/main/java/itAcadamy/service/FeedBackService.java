package itAcadamy.service;

import dto.DeleteOrFindDto;
import dto.feedback.FeedBackRequest;
import dto.feedback.FeedBackResponse;
import itAcadamy.entity.FeedBack;
import itAcadamy.entity.OrderHotel;
import itAcadamy.exception.OrderException;
import itAcadamy.mapper.FeedBackMapper;
import itAcadamy.repository.FeedBackDao;
import itAcadamy.repository.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.CrudService;
import service.FeedBackApi;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FeedBackService extends CrudService<FeedBack, FeedBackRequest, FeedBackResponse> implements FeedBackApi {
    private final FeedBackDao feedBackDao;
    private final OrderDao orderDao;
    private final FeedBackMapper feedBackMapper;

    @Autowired
    public FeedBackService(FeedBackMapper feedBackMapper, FeedBackDao feedBackDao, OrderDao orderDao) {
        super(feedBackMapper, feedBackDao);
        this.feedBackDao = feedBackDao;
        this.orderDao = orderDao;
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
    public List<FeedBackResponse> getFeedBackInHotelUser(FeedBackRequest feedBackRequest) {
        return feedBackDao.getFeedBackInHotelUser(feedBackRequest.getHotel().getId(), feedBackRequest.getId()).stream().map(feedBackMapper::createResponse).collect(Collectors.toList());
    }
}
