package com.microservice.login.auth.service.impl;

import com.microservice.login.auth.entity.User;
import com.microservice.login.auth.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author lw
 * @date 2020/11/25 11:44
 */
@Service("UserService")
public class UserServiceImpl implements UserService {

    @Override
    public User loadUserByUsername(String userName) {
        User user = new User();
        String passWord = "123";
        user.setUsername(userName);
        user.setPassword(new BCryptPasswordEncoder().encode(passWord));
        user.setId(UUID.randomUUID().toString());
        return user;
    }
}
