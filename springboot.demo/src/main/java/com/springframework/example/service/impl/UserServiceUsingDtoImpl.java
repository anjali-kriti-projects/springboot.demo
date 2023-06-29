package com.springframework.example.service.impl;

import com.springframework.example.dto.UserDto;
import com.springframework.example.entity.User;
import com.springframework.example.mapper.UserMapper;
import com.springframework.example.repository.UserRepository;
import com.springframework.example.service.UserServiceUsingDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceUsingDtoImpl implements UserServiceUsingDto {

    private UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto userDto) {

        User user = UserMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);
        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long id) {
        Optional<User> existingUser= userRepository.findById(id);
        UserDto existingUserDto = UserMapper.mapToUserDto(existingUser.get());
        return existingUserDto;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> allUser = userRepository.findAll();
        return allUser.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User existingUser = userRepository.findById(userDto.getId()).get();
        existingUser.setFirstName(userDto.getFirstName());
        existingUser.setLastName(userDto.getLastName());
        existingUser.setEmail(userDto.getEmail());

        User upadtedUser = userRepository.save(existingUser);
        UserDto upadtedUserDto = UserMapper.mapToUserDto(upadtedUser);

        return upadtedUserDto;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
