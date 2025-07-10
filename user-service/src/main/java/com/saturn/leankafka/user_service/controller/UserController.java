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
        kafkaTemplate.send(topicName, message);
        return new ResponseEntity<>("message queued", HttpStatus.OK);
    }

}
