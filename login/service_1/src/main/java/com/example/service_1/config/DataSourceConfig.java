package com.example.service_1.config;

import com.alibaba.druid.pool.DruidDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 设置seata的datasource,这里必须设置，seata的全局事物是基于此借助服务的datasource进行数据操作
 *
 * @author lw
 * @date 2020/12/1 22:14
 */
@Configuration
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return new DruidDataSource();
    }

    @Primary
    @Bean
    public DataSource dataSource(DataSource dataSource) {
        return new DataSourceProxy(dataSource);
    }
}
