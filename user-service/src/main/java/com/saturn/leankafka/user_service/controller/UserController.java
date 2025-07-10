package com.saturn.leankafka.user_service.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(path = "/users")
@RequiredArgsConstructor
public class UserController {

    @Value("${kafka.topic-name}")
    String topicName;

    private final KafkaTemplate<String, String> kafkaTemplate;


    @PostMapping("/{message}")
    public ResponseEntity<String> sendMessage(@PathVariable String message){

        for(int i=0;i<=1000;i++) {
            kafkaTemplate.send(topicName,""+i%2, message+i);
        }
        return new ResponseEntity<>("message queued", HttpStatus.OK);
    }

}
