package com.example.BankingApplication.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {

    //Matches the exact execution of a method
    @Before("execution(* com.example.BankingApplication.service.*.*(..))")
    public void logExecution(){
        System.out.println("Executing service method: deposit");
    }

    //Matches All methods inside All classes in the service package.
    @Before("within(com.example.BankingApplication.service..*)")
    public void logWithin(){
        System.out.println("Method inside service package invoked");
    }

    //Matches All methods in any class that has the @Service annotation
    @Before("@within(org.springframework.stereotype.Service)")
    public void atWithin(){
        System.out.println("Class annotated with @Service executed");
    }

    //matches any method on a particular instance of the class
    @Before("target(com.example.BankingApplication.service.BankService)")
    public void targetLog(){
        System.out.println("Target object is BankService");
    }

    //Matches only methods that have @TrackExecution annotation on them
    @Before("@annotation(com.example.BankingApplication.annotation.TrackExecution)")
    public void trackExecutionLog(){
        System.out.println("Tracked Method Executed");
    }
}
