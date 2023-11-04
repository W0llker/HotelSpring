package service;

import dto.feedback.FeedBackRequest;
import dto.feedback.FeedBackResponse;

public interface FeedBackApi {
    void addFeedbackInOrder(Long orderId, FeedBackRequest feedBackRequest);

    FeedBackResponse findFeedbackByOrderId(Long orderId);

    void deleteFeedBack(Long idFeedBack);

    void updateFeedback(FeedBackRequest feedBackRequest);
}
