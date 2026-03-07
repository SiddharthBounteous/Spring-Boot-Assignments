package com.example.BankingApplication.service;

import com.example.BankingApplication.annotation.TrackExecution;
import org.springframework.stereotype.Service;

@Service
public class BankService {

    private int balance=0;

    public String deposit(int amount){
        balance+=amount;
        return "Deposited: "+amount+". New balance: "+balance;
    }

    @TrackExecution
    public String withdraw(int amount){
        if(amount>balance){
            throw new RuntimeException("Insufficient balance!");
        }
        balance-=amount;
        return "Withdrawn: "+amount+". New balance: "+balance;
    }

    public int getBalance(){
        return balance;
    }
}
