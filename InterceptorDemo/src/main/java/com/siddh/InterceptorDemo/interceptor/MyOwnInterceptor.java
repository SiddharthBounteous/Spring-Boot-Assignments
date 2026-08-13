package com.siddh.InterceptorDemo.interceptor;

import com.siddh.InterceptorDemo.annotation.MyCustomAnnotation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import org.aspectj.lang.reflect.MethodSignature;
@Component
@Aspect
public class MyOwnInterceptor {
    @Around("@annotation(com.siddh.InterceptorDemo.annotation.MyCustomAnnotation)")
    public void invoke(ProceedingJoinPoint proceedingJoinPont) throws Throwable{
        System.out.println("Do something before actual method");
        Method method=((MethodSignature)proceedingJoinPont.getSignature()).getMethod();
        if(method.isAnnotationPresent(MyCustomAnnotation.class)){
            MyCustomAnnotation annotation=method.getAnnotation(MyCustomAnnotation.class);
            System.out.println("name from annotation: "+annotation.key());
        }

        proceedingJoinPont.proceed();
        System.out.println("Do something after actual method");
    }
}
