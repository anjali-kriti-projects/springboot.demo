package com.springframework.example.controller;

import com.springframework.example.dto.UserDto;
import com.springframework.example.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private UserService userService;
    @PostMapping
    public ResponseEntity<UserDto> createUser (@RequestBody UserDto userDto){
        UserDto savedUser = userService.createUser(userDto);
        return  new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById (@PathVariable ("id") Long id){
        UserDto user = userService.getUserById(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUser (){
        List<UserDto> allUser = userService.getAllUsers();
        return new ResponseEntity<>(allUser,HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser (@PathVariable ("id") Long userId, @RequestBody UserDto user){
        user.setId(userId);
        UserDto updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser (@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User successfully deleted!",HttpStatus.OK);
    }

}
