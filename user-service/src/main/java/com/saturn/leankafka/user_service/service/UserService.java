package com.saturn.leankafka.user_service.service;

import com.saturn.leankafka.user_service.dto.CreateUserRequestDto;
import com.saturn.leankafka.user_service.entity.User;
import com.saturn.leankafka.user_service.event.UserCreatedEvent;
import com.saturn.leankafka.user_service.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {


    @Value("${kafka.user-created-topic-name}")
    String userCreatedTopic;
    private final UserRepo userRepo;
    private final ModelMapper mapper;
    private final KafkaTemplate<Long, UserCreatedEvent> template;

    public void createUser(CreateUserRequestDto createUserRequestDto){
        User user = mapper.map(createUserRequestDto, User.class);
        User savedUser = userRepo.save(user);

        UserCreatedEvent userCreatedEvent = mapper.map(savedUser, UserCreatedEvent.class);
        template.send(userCreatedTopic, userCreatedEvent.getId(), userCreatedEvent);
    }


}
