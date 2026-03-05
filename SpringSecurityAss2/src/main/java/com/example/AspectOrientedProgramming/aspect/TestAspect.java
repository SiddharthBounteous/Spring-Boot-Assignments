package com.example.AspectOrientedProgramming.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TestAspect {

    //point cut expression
//    @Before("execution(public String com.example.SpringSecurityAss2.controller.TestController.testAOP1())")
//    public void testMethod(){
//        System.out.println("Start of the method");
//    }
//
//    @After("execution(public String com.example.SpringSecurityAss2.controller.TestController.testAOP1())")
//    public void testMethod2(){
//        System.out.println("End of the method");
//    }

    //within is on class level
//    @Before("within(com.example.SpringSecurityAss2.controller.*)")
//    public void testMethod3(){
//        System.out.println("Start of the method");
//    }

    //@within-> it matches the method in a class which has this annotation
    @Before("@within(org.springframework.stereotype.Service)")
    public void testMethod4(){
        System.out.println("Start of the method");
    }

    //@Annotation-> matches any method that it is given annotated
    //Args-> it matches any method with any particular argument
    //@Before("args(String,int)")  //match any method with this signature

    //
}
