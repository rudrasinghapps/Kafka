package com.delivery.boy.controller;

import com.delivery.boy.payload.Employe;
import com.delivery.boy.payload.Student;
import com.delivery.boy.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmpService empService;

    @PostMapping
    public ResponseEntity<Employe> saveStudent(@RequestBody Employe employe){
        empService.createEmp(employe);
        return ResponseEntity.status(HttpStatus.OK).body(employe);
    }
}
