package com.siddh.InterceptorDemo.model;

import com.siddh.InterceptorDemo.annotation.MyCustomAnnotation;
import org.springframework.stereotype.Component;

@Component
public class User {
    String name="Siddharth";

    @MyCustomAnnotation(key="getUser")
    public void getUser(){
        System.out.println(name);
    }

    @MyCustomAnnotation(key= "userKey", classTypeKey=User.class)
    public void updateUser(){
        //some business logic
    }
}
