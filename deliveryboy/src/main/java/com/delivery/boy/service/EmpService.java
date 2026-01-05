package com.delivery.boy.service;

import com.delivery.boy.payload.Employe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmpService {
    @Autowired
    private  KafkaTemplate<String ,Object> kafkaTemplate;
    private final Logger logger = LoggerFactory.getLogger(EmpService.class);

    public void createEmp(Employe emp) {
        logger.info(" ===  Employee send to kafka event producer  === ");
        kafkaTemplate.send("employee-topic" ,emp);
    }

}
