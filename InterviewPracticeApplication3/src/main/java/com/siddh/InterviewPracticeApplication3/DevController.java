package com.siddh.InterviewPracticeApplication3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DevController {
    @GetMapping("/name")
    public String getName(){
        return "Siddharth"; //consider it as a data
    }
}
