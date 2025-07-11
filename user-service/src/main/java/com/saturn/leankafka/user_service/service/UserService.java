package com.saturn.leankafka.user_service.service;

import com.saturn.leankafka.user_service.dto.CreateUserRequestDto;
import com.saturn.leankafka.user_service.entity.User;
import com.saturn.leankafka.user_service.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;
    private final ModelMapper mapper;

    public void createUser(CreateUserRequestDto createUserRequestDto){
        User user = mapper.map(createUserRequestDto, User.class);
        userRepo.save(user);
    }


}
