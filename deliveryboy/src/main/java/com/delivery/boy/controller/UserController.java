package com.delivery.boy.controller;

import com.delivery.boy.payload.Student;
import com.delivery.boy.payload.User;
import com.delivery.boy.service.StudentService;
import com.delivery.boy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserService userService;

    @PostMapping
    public ResponseEntity<User> saveStudent(@RequestBody User user){
        userService.createUser(user);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

}
