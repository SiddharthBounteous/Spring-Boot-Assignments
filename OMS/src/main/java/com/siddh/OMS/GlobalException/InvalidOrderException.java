package com.siddh.OMS.GlobalException;

public class InvalidOrderException extends RuntimeException {
    public InvalidOrderException(String message){
        super(message);
    }
}
