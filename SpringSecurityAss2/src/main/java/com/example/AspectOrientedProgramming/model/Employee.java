package com.example.AspectOrientedProgramming.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Service
@RequestMapping("/api/emp")
//@ResponseBody
public class Employee {

    @Autowired
    EmployeeImpl empImpl;

    @GetMapping("/get3")
    public String getEmployee(){
        empImpl.getEmployee();
        return "hello employee";
    }
}
