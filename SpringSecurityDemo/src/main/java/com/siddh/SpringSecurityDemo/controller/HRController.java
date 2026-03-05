package com.siddh.SpringSecurityDemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hr")
public class HRController {

    @GetMapping("/hello")
    public String helloHR() {
        return "Hello HR (or ADMIN)";
    }
}
