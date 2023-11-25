package itAcadamy.mapper;

import dto.user.UserRequest;
import dto.user.UserResponse;
import itAcadamy.entity.User;
import mapper.SupperMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends SupperMapper<User, UserRequest, UserResponse> {
}
