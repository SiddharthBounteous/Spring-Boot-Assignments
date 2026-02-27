package com.siddh.library.controller;

import com.siddh.library.service.TransactionDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionalController {
    @Autowired
    TransactionDemo transactionDemo;


    @GetMapping("/test")
    public String testTransaction() {
        System.out.println("Endpoint /test was hit!"); // Prints to console

        transactionDemo.methodA(); // calling the service

        System.out.println("Transaction finished!"); // Prints to console
        return "Transaction executed!";
    }
}
