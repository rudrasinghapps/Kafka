package com.enduser.controller;


import com.enduser.payload.Student;
import com.enduser.service.StudentConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentConsumer studentConsumer;

    @GetMapping
    public ResponseEntity<Student> getStudentFromKafka(){
       Student student= studentConsumer.getStudentObject();
       return ResponseEntity.status(HttpStatus.OK).body(student);
    }
}
