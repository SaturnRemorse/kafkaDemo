package com.saturn.leankafka.user_service.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

    @Value("${kafka.topic-name}")
    String topicName;

    @Bean
    public NewTopic userRandomTopic(){
        return new NewTopic(topicName, 3 , (short)1);
    }
}
