package com.example.usermicroservice.service;

import com.example.usermicroservice.model.dto.UserDto;
import com.example.usermicroservice.model.entity.User;
import com.example.usermicroservice.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private static final ModelMapper modelMapper = new ModelMapper();

    @Override
    @Transactional
    public UserDto createUser(UserDto user) {

        user.setUserId(UUID.randomUUID().toString());
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        User userEntity = modelMapper.map(user, User.class);
        userEntity.setEncryptedPassword("test");
        userRepository.save(userEntity);

        UserDto returnValue = modelMapper.map(userEntity, UserDto.class);

        return returnValue;
    }
}
