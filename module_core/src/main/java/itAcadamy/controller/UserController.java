package itAcadamy.controller;

import annotation.LoggerAnnotation;
import controller.UserControllerApi;
import dto.user.UserRequest;
import dto.user.UserResponse;
import jakarta.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.UserApi;
@RestController
@RequestMapping("user")
public class UserController implements UserControllerApi {
    private final UserApi userApi;
    @Autowired
    public UserController(UserApi userApi) {
        this.userApi = userApi;
    }

    @Override
    @LoggerAnnotation
    public UserResponse login(UserRequest userRequest) throws ServletException {
        return userApi.login(userRequest);
    }

    @Override
    @LoggerAnnotation
    public void logout() throws ServletException {
        userApi.logout();
    }
}
