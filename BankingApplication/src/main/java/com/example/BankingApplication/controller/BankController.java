package com.example.BankingApplication.controller;

import com.example.BankingApplication.service.AuditService;
import com.example.BankingApplication.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class BankController {

    @Autowired
    BankService bankService;

    @Autowired
    private AuditService auditService;

    @PostMapping("/deposit/{amount}")
    public String deposit(@PathVariable int amount){
        return bankService.deposit(amount);
    }

    @PostMapping("/withdraw/{amount}")
    public String withdraw(@PathVariable int amount){
        return bankService.withdraw(amount);
    }

    @GetMapping("/balance")
    public int getBalance(){
        return bankService.getBalance();
    }

    @GetMapping("/audit")
    public String audit(){
        auditService.auditTransaction();
        return "ok";
    }
}
