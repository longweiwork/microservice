package com.example.service_1.service;

import com.microservice.model.User;

/**
 * @author lw
 * @date 2020/12/3 10:53
 */
public interface UserService {

    void saveUser(User user);

    void saveLocalManager(User user);
}
