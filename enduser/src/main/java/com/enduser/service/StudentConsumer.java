package com.enduser.service;

import com.enduser.payload.Student;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
public class StudentConsumer {

    private Student student;

//    @KafkaListener(topics = "student-topic", groupId = "student-group")
//    public void consume1(Student student) {
//        System.out.println("Student received Consume {  1  } =========== > " + student);
//        this.student=student;
//    }

    public Student getStudentObject() {
        return this.student;
    }

    // Read message from all partitions
//    @KafkaListener(topics = "student-topic", groupId = "student-group")
//    public void consume(Student student, @Header(KafkaHeaders.RECEIVED_PARTITION) int partition){
//        System.out.println("Received => " + student + " from partition => " + partition);
//    }


    //Read message from particular partitions
    @KafkaListener(topicPartitions = @TopicPartition(topic = "student-topic", partitions = {"1"}), groupId = "student-group")
    public void consumePartition1(Student student) {
        System.out.println(" Revived from PARTITION 1 ------> " + student);
    }

    //Read message from particular partitions
    @KafkaListener(topicPartitions = @TopicPartition(topic = "student-topic", partitions = {"2"}), groupId = "student-group")
    public void consumePartition2(Student student) {
        System.out.println(" Revived from PARTITION 2 ------> " + student);
    }

    @KafkaListener(topicPartitions = @TopicPartition(topic = "student-topic", partitions = {"2"}), groupId = "student-group-consumer_3")
    public void consumePartition3(Student student) {
        System.out.println(" Revived from PARTITION 3 ------> " + student);
    }


}
