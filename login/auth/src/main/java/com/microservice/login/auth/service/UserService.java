package com.microservice.login.auth.service;

import com.microservice.login.auth.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author lw
 * @date 2020/11/25 11:35
 */
public interface UserService extends UserDetailsService {

    @Override
    User loadUserByUsername(String userName);

}
