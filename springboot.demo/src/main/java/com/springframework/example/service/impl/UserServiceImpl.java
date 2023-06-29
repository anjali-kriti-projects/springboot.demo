package com.springframework.example.service.impl;

import com.springframework.example.dto.UserDto;
import com.springframework.example.entity.User;
import com.springframework.example.repository.UserRepository;
import com.springframework.example.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;
    @Override
    public UserDto createUser(UserDto userDto) {

        User user = modelMapper.map(userDto, User.class);
        User savedUser = userRepository.save(user);
        UserDto savedUserDto = modelMapper.map(savedUser,UserDto.class);
        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long id) {
        Optional<User> existingUser= userRepository.findById(id);
        UserDto existingUserDto = modelMapper.map(existingUser.get(), UserDto.class);
        return existingUserDto;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> allUser = userRepository.findAll();
        return allUser.stream().map((user) -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User existingUser = userRepository.findById(userDto.getId()).get();
        existingUser.setFirstName(userDto.getFirstName());
        existingUser.setLastName(userDto.getLastName());
        existingUser.setEmail(userDto.getEmail());

        User upadtedUser = userRepository.save(existingUser);
        UserDto upadtedUserDto = modelMapper.map(upadtedUser, UserDto.class);

        return upadtedUserDto;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
