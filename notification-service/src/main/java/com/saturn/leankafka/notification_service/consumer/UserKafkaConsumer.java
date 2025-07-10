package com.saturn.leankafka.notification_service.consumer;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserKafkaConsumer {


    @KafkaListener(topics ="user-random-topic" )
    public void handleUserRandomTopic(String message){
        log.info("message received: {}" , message);
    }


}
