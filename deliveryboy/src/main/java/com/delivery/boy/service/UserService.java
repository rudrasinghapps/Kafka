package com.delivery.boy.service;

import com.delivery.boy.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private KafkaTemplate<String ,Object> kafkaTemplate;
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    public void createUser(User user) {
        logger.info("  ===  User send to kafka event producer  === ");
        kafkaTemplate.send("user-topic" ,user);
    }


}
