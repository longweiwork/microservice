package com.example.service_1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lw
 * @date 2020/11/27 11:30
 */
@Configuration
public class FeignConfig {

    /**
     * 自定义feign拦截器，头部加入自己需要的信息
     * @return
     */
    @Bean
    public CustomFeignInterceptor basicAuthRequestInterceptor() {
        return new CustomFeignInterceptor();
    }

}
