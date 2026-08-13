package com.siddh.FiltersAndInterceptorDemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/panel")
    public void adminPanel(HttpServletRequest request){
        System.out.println("ThreadId-> "+request.getAttribute("threadId")+" Request Number-> "+request.getAttribute("requestNumber")+" Entered into admin panel");
    }
}
