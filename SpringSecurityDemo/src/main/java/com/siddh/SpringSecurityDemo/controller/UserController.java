package com.siddh.SpringSecurityDemo.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/hello")
    public String helloUser() {
        return "Hello employee (or ADMIN)";
    }
}
