package com.siddh.springdatajpademo2.controller;

import com.siddh.springdatajpademo2.entity.User;
import com.siddh.springdatajpademo2.repository.UserRepository;
import com.siddh.springdatajpademo2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/v1/api")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        User user=userService.getUserDetailsById(id);
        return user;
    }

    @PostMapping("/create")
    public String createNewUser(@RequestBody User user){
        userService.setUserDetails(user);
        return "User Created";
    }



}
