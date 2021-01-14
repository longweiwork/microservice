package com.example.gateway.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;

/**
 * @author lw
 * @date 2020/11/30 21:32
 */
@Component
public class KafkaProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    /**
     * 发送消息
     * @param message
     */
    public void sendMessage(String message){

        ListenableFuture test = kafkaTemplate.send("test", message);

        try {
            Object o = test.get();

            System.out.println(o);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }


}
