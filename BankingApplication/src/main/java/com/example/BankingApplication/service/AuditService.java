package com.example.BankingApplication.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class AuditService {
    public void auditTransaction(){
        System.out.println("Auditing.....");
    }
}
