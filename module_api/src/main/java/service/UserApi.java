package service;

import dto.user.UserRequest;
import dto.user.UserResponse;
import jakarta.servlet.ServletException;

public interface UserApi {
    UserResponse login(UserRequest userRequest) throws ServletException;
    void logout() throws ServletException;
}
