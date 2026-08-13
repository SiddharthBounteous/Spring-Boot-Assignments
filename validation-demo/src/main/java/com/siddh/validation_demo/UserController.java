package com.siddh.validation_demo;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/user")
    public String createUser(@RequestBody @Valid User user){

        //create user in db
        return "Created a valid user";
    }
}
