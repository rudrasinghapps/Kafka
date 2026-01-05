package com.enduser.service;


import com.enduser.payload.Student;
import com.enduser.payload.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class UserConsumer {

    private User user;

    @KafkaListener(topics = "user-topic" , groupId = "user-group")
    public void consume(User user) {
        System.out.println("User received ========> " + user);
        this.user=user;
    }

    public User getUserObject(){
        return this.user;
    }

}
