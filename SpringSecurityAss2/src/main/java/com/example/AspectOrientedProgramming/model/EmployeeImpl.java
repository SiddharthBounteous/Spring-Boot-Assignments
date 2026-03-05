package com.example.AspectOrientedProgramming.model;

import org.springframework.stereotype.Service;

@Service
public class EmployeeImpl {

    public String getEmployee(){
        System.out.println("Printed from EmployeeImpl");
       return "EmployeeImpl";
    }
}
