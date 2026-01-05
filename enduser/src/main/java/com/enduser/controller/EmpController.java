package com.enduser.controller;


import com.enduser.payload.Employe;
import com.enduser.service.EmpConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmpConsumer empConsumer;

    @GetMapping
    public ResponseEntity<Employe> getEmployeeFromKafka(){
        return ResponseEntity.status(HttpStatus.OK).body(empConsumer.getEmploye());
    }
}
