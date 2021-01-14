package com.example.gateway.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author lw
 * @date 2020/11/30 22:16
 */
@Component
public class KafkaConsumer {

    @KafkaListener(topics = "test")
    private void receiveMessage(ConsumerRecord record){

        Object value = record.value();

        System.out.println(value);

    }


}
