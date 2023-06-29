package com.springframework.example.service;

import com.springframework.example.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);
    UserDto getUserById(Long id);

    List<UserDto> getAllUsers();

    UserDto updateUser (UserDto user);

    void deleteUser (Long id);
}
