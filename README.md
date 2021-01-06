# microservice

微服务架构，涉及模块分为以下几部分：

1.web:前端

2.auth:授权

3.gateway:做请求的分发、负载均衡、请求验证、过滤、信息添加等工作

4.service:根据具体需求添加，不做服务的登录等验证(多个)

5.nacos:注册中心，配置中心

6.elk:日志收集

7.seata:分布式事务控制

可考虑加入sentinel等来进一步完整化项目