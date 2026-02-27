package com.siddh.library.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionDemo {


    @Transactional(propagation = Propagation.REQUIRED)
    public void methodA() {
        System.out.println("Executing methodA on Thread: " + Thread.currentThread().getName());
        methodB(); // calls another transactional method
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void methodB() {
        System.out.println("Executing methodB on Thread: " + Thread.currentThread().getName());
        // some database operation
    }
}
