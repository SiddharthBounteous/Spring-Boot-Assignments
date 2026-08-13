package com.siddh.HibernateProblemDemo.controller;

import com.siddh.HibernateProblemDemo.entity.Department;
import com.siddh.HibernateProblemDemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/dep")
    public ResponseEntity<?> fetchAllDepartments(){
        try{
            return new ResponseEntity<>(employeeService.getAllDepartments(), HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
