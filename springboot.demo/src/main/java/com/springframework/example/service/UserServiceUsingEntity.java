package com.springframework.example.service;

import com.springframework.example.entity.User;

import java.util.List;

public interface UserServiceUsingEntity {
    User createUser(User user);
    User getUserById(Long id);

    List<User> getAllUsers();

    User updateUser (User user);

    void deleteUser (Long id);
}
