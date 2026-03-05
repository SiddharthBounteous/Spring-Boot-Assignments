package com.siddh.SpringSecurityDemo2.controller;

import com.siddh.SpringSecurityDemo2.dto.UserLogin;
import com.siddh.SpringSecurityDemo2.dto.UserRegister;
import com.siddh.SpringSecurityDemo2.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<Map<String,String>> register(@RequestBody UserRegister req){
        return ResponseEntity.ok(authService.registerUser(req));
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String,String>> login(@RequestBody UserLogin req){
        return ResponseEntity.ok(authService.loginUser(req));
    }
}
