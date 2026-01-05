package com.delivery.boy.service;

import com.delivery.boy.payload.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;
    private final Logger logger = LoggerFactory.getLogger(StudentService.class);

    public void createStudent(Student student) {
        System.out.println(student);
        logger.info("===  Student send to kafka event producer  === ");

        // Message send to any partition ( 0 - 4 )
//        for (int i = 0; i < 2000; i++) {
//            student.setCity("Num -> " +i);
//            kafkaTemplate.send("student-topic", student);
//        }

         //Send message to specific partition( ONLY 1  )
        for (int i = 0; i < 20; i++)  kafkaTemplate.send("student-topic", 1, null, student);

        // Send message to specific partition( ONLY 2  )
        //for (int i = 0; i < 20; i++)  kafkaTemplate.send("student-topic", 2, null, student);

        // Send message to specific partition( ONLY 3  )
        //for (int i = 0; i < 20; i++)  kafkaTemplate.send("student-topic", 3, null, student);


    }


}
