package com.enduser.controller;


import com.enduser.payload.Student;
import com.enduser.payload.User;
import com.enduser.service.StudentConsumer;
import com.enduser.service.UserConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserConsumer userConsumer;

    @GetMapping
    public ResponseEntity<User> getUserFromKafka(){
        User user= userConsumer.getUserObject();
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }


}
