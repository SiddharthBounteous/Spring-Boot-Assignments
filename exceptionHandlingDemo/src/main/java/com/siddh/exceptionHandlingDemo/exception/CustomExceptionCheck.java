package com.siddh.exceptionHandlingDemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST,reason = "Invalid request is passed")
public class CustomExceptionCheck extends RuntimeException{

    HttpStatus httpStatus;

    public CustomExceptionCheck(HttpStatus status,String message){
        super(message);
        this.httpStatus=status;
    }
}
