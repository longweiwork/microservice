package com.example.gateway.controller;

import com.example.gateway.kafka.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试Controller
 */
@Slf4j
@RestController
public class TestController {

    private Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private KafkaProducer kafkaProducer;

    @RequestMapping("/test")
    public String test() {
        logger.info("123");
        return "123";
    }

    @RequestMapping("kafka")
    public void kafka() {
        logger.info("kafka");
        kafkaProducer.sendMessage("kafka");
    }
}
