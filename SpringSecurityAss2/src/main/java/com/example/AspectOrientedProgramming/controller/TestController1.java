package com.example.AspectOrientedProgramming.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2")
public class TestController1 {
    @GetMapping("/get1")
    public String testAOP1(){
        System.out.println("Inside testAOP1");
        return "I am starting AOP1";
    }

    @GetMapping("/get2")
    public String testAOP2(){
        System.out.println("Inside testAOP2");
        return "I am starting AOP2";
    }
}
