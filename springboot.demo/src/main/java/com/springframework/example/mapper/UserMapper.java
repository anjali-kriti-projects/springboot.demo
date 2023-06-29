package com.springframework.example.mapper;

import com.springframework.example.dto.UserDto;
import com.springframework.example.entity.User;

public class UserMapper {

    // Converting User JPA Entity to into User Dto
    public static UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto(user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail());
        return userDto;
    }

    //Convert User Dto into User JPA Entity

    public static User mapToUser(UserDto userDto) {
        User user = new User(userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail());
        return user;
    }
}
