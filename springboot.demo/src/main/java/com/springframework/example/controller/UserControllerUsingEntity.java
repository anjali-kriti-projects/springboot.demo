//package com.springframework.example.controller;
//
//import com.springframework.example.entity.User;
//import com.springframework.example.service.UserService;
//import com.springframework.example.service.UserServiceUsingEntity;
//import lombok.AllArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@AllArgsConstructor
//@RequestMapping("api/users")
//public class UserControllerUsingEntity {
//
//    private UserServiceUsingEntity userService;
//    @PostMapping
//    public ResponseEntity<User> createUser (@RequestBody User user){
//        User savedUser = userService.createUser(user);
//        return  new ResponseEntity<>(savedUser, HttpStatus.CREATED);
//    }
//
//    @GetMapping("{id}")
//    public ResponseEntity<User> getUserById (@PathVariable ("id") Long id){
//        User user = userService.getUserById(id);
//        return new ResponseEntity<>(user,HttpStatus.OK);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<User>> getAllUser (){
//        List<User> allUser = userService.getAllUsers();
//        return new ResponseEntity<>(allUser,HttpStatus.OK);
//    }
//
//    @PutMapping("{id}")
//    public ResponseEntity<User> updateUser (@PathVariable ("id") Long userId, @RequestBody User user){
//        user.setId(userId);
//        User updatedUser = userService.updateUser(user);
//        return new ResponseEntity<>(updatedUser,HttpStatus.OK);
//    }
//
//    @DeleteMapping("{id}")
//    public ResponseEntity<String> deleteUser (@PathVariable("id") Long userId){
//        userService.deleteUser(userId);
//        return new ResponseEntity<>("User successfully deleted!",HttpStatus.OK);
//    }
//
//}
