package com.example.usermicroservice.service;


import com.example.usermicroservice.model.dto.UserDto;

public interface UserService {

    UserDto createUser(UserDto user);
}
