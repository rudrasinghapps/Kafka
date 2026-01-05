package com.enduser.service;

import com.enduser.payload.Employe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EmpConsumer {

    private static final Logger logger = LoggerFactory.getLogger(EmpConsumer.class);
    private Employe employe;

    @KafkaListener(topics = "employee-topic", groupId = "employee-group")
    public void consume(Employe employee) {
        logger.info("Employee received =========>: {}", employee);
        this.employe = employee;
    }

    public Employe getEmploye(){
        return this.employe;
    }




}
