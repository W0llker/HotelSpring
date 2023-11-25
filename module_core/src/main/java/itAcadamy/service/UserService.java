package itAcadamy.service;

import dto.user.UserRequest;
import dto.user.UserResponse;
import itAcadamy.entity.User;
import itAcadamy.mapper.UserMapper;
import itAcadamy.repository.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import service.UserApi;

@Service
public class UserService implements UserApi, UserDetailsService {
    private final UserDao userDao;
    private final UserMapper userMapper;
    private final HttpServletRequest httpServletRequest;

    @Autowired
    public UserService(UserDao userDao, HttpServletRequest httpServletRequest, UserMapper userMapper) {
        this.userDao = userDao;
        this.userMapper = userMapper;
        this.httpServletRequest = httpServletRequest;
    }

    @Override
    public UserResponse login(UserRequest userRequest) throws ServletException {
        httpServletRequest.login(userRequest.getLogin(), userRequest.getPassword());
        return userMapper.createResponse(userMapper.createEntity(userRequest));
    }

    @Override
    public void logout() throws ServletException {
        httpServletRequest.logout();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByLogin(username);
        if (user != null)
            return user;
        throw new UsernameNotFoundException("");
    }
}
