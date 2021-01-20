package com.example.service_1.service.impl;

import com.example.service_1.service.FeignService;
import com.example.service_1.service.UserService;
import com.microservice.mapper.UserMapper;
import com.microservice.model.User;
import io.seata.rm.datasource.exec.ExecuteTemplate;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author lw
 * @date 2020/12/3 10:53
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Resource
    private FeignService feignService;

    @Override
    @GlobalTransactional(rollbackFor=Exception.class)
    public void saveUser(User user) {
        userMapper.insert(user);

        feignService.getByFeign("123");
    }

    /**{@link ExecuteTemplate}
     *
     * 未配置GlobalTransactional时使用本身的事务，需要根据自己的配置来
     * @param user
     */
    @Override
    @Transactional
    public void saveLocalManager(User user) {
        userMapper.insert(user);

//        throw new RuntimeException("123");
    }


}
