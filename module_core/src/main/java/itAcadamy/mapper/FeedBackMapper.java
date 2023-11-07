package itAcadamy.mapper;

import dto.feedback.FeedBackRequest;
import dto.feedback.FeedBackResponse;
import itAcadamy.entity.FeedBack;
import mapper.SupperMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FeedBackMapper extends SupperMapper<FeedBack, FeedBackRequest, FeedBackResponse> {
}
