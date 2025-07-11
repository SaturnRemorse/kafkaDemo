package com.saturn.leankafka.user_service.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

    @Value("${kafka.topic-name}")
    String topicName;

    @Value("${kafka.user-created-topic-name}")
    String userCreatedTopic;

    @Bean
    public NewTopic userRandomTopic(){
        return new NewTopic(topicName, 3 , (short)1);
    }

    @Bean
    public NewTopic userCreatedTopic(){
        return new NewTopic(userCreatedTopic, 3 , (short)1);
    }
}
