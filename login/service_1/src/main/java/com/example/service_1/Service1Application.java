package com.example.service_1;

import com.example.service_1.service.FeignService;
import com.example.service_1.service.UserService;
import com.microservice.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Random;

/**
 * 对于后续服务我认为可以通过服务器端口屏蔽的方式来避免直访服务，服务本身没必要做更多的权限验证
 *
 * 充分发挥微服务的理念，做到任务分类清晰化
 */
@EnableDiscoveryClient
@RestController
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableFeignClients
@MapperScan(basePackages = {"com.microservice.mapper"})
public class Service1Application {

    public static void main(String[] args) {
        SpringApplication.run(Service1Application.class, args);
    }

    @Resource
    private FeignService feignService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/test")
    public String test(HttpServletRequest request){

        Enumeration<String> headerNames = request.getHeaderNames();

        while (headerNames.hasMoreElements()){
            String s = headerNames.nextElement();

            System.out.println("header:"+s+"  value:"+request.getHeader(s));
        }

        String feign = feignService.getByFeign("12345");

        System.out.println(feign);

        return "成功访问";
    }

    @RequestMapping(value = "/save")
    public String save(HttpServletRequest request){

        User user = new User();

        user.setId(new Random().nextInt(100));
        user.setName("long");
        user.setAge(100);

        userService.saveUser(user);

        return "成功访问";
    }

    @RequestMapping(value = "/saveLocal")
    public String saveLocal(HttpServletRequest request){

        User user = new User();

        user.setId(new Random().nextInt(1000));
        user.setName("lw");
        user.setAge(100);

        userService.saveLocalManager(user);

        return "成功访问";
    }

}
