package com.siddh.InterviewPracticeApplication2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    public EmployeeController(){
        System.out.println("Employee Controller Bean Created");
    }

    @GetMapping("/test")
    public ResponseEntity<String>learnAboutResponseEntity(){
        //you can return class's object also
//        return new ResponseEntity<>("Learning Response Entity", HttpStatus.OK);  //first way

        //return ResponseEntity.ok("Learning ResponseEntity");  //second way-> using static methods of response entity class

        return ResponseEntity
                .accepted()
                .header("X-Custom-Header","Value of header")
                .body("Learning about response entity");
    }
}
