package com.siddh.exceptionHandlingDemo.exception;

import org.springframework.http.HttpStatus;


public class CustomException extends RuntimeException{
    HttpStatus httpStatus;
    String message;

    public CustomException(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public HttpStatus getHttpStatus(){
        return httpStatus;
    }

    public String getMessage(){
        return message;
    }
}
