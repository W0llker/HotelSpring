package itAcadamy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.UserApi;
@RestController
@RequestMapping("user")
public class UserController {
    private final UserApi userApi;
    @Autowired
    public UserController(UserApi userApi) {
        this.userApi = userApi;
    }
}
