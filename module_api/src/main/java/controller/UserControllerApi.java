package controller;

import dto.user.UserRequest;
import dto.user.UserResponse;
import jakarta.servlet.ServletException;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

public interface UserControllerApi {
    @GetMapping("/login")
    UserResponse login(@RequestBody @Valid UserRequest userRequest) throws ServletException;
    @PostMapping("/logout")
    void logout() throws ServletException;
}
