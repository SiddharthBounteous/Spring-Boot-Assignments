package com.siddh.SpringSecurityDemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mng")
public class ManagerController {

    @GetMapping("/hello")
    public String helloMng() {
        return "Hello Manager (or ADMIN)";
    }
}
