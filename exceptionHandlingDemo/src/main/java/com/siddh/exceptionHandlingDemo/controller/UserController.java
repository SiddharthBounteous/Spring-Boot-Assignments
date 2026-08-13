package com.siddh.exceptionHandlingDemo.controller;

import com.siddh.exceptionHandlingDemo.exception.CustomException;
import com.siddh.exceptionHandlingDemo.exception.CustomExceptionCheck;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.siddh.exceptionHandlingDemo.exception.ErrorResponse;

import java.io.IOException;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping("/get-user")
    public ResponseEntity<?> getUser(){
//        throw  new NullPointerException("Testing null pointer exception");
        //we are not returning the response Entity therefore some other class is returning that details that is default error attributes
        throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR,"request is not correct, userId is missing");

//        try{
//            throw new CustomException(HttpStatus.BAD_REQUEST,"request is not correct, userId is missing");
//        }
//        catch(CustomException ex){
//            ErrorResponse errorResponse=new ErrorResponse(new Date(),ex.getMessage(),ex.getHttpStatus().value());
//            return new ResponseEntity<>(errorResponse,ex.getHttpStatus());
//        } catch (Exception ex) {
//            ErrorResponse errorResponse=new ErrorResponse(new Date(),ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR.value());
//            return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
//        }

//        throw new CustomExceptionCheck(HttpStatus.ACCEPTED,"User Id is missing");
    }

    @GetMapping("/get-user-history")
    public ResponseEntity<?>getUserHistory(){
        throw new IllegalArgumentException("Illegal Type Exception");
    }

    //this handler is responsible for handling custom exception
//    @ExceptionHandler(CustomException.class)
//    @ResponseStatus(value = HttpStatus.BAD_REQUEST,reason = "Sending from Response Status")
//    public ResponseEntity<String> handleCustomException(CustomException ex){
//        return new ResponseEntity<>(ex.getMessage(),ex.getHttpStatus());
//
//        //the control will never go to the Response Status resolver as we are returning response entity
//        //it is overridden by spring framework not exception resolver (ServletInvocableHandlerMethod)
//        return new ResponseEntity<>("You are not authorized",HttpStatus.FORBIDDEN);  //will print "Sending from Response Status"
//    }


    //this handler is responsible for handling custom exception
    @ExceptionHandler(CustomException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST,reason = "Sending from Response Status")
    public void handleCustomException(HttpServletResponse response,CustomException ex) throws IOException {
//        response.sendError(HttpStatus.BAD_REQUEST.value(),ex.getMessage());  //now it goes to default error attributes

        //here the response is committed, so ExceptionHandlerResolver itself throws Exception
        response.sendError(HttpStatus.FORBIDDEN.value(),"You are not authorized");
    }

    //this handler is responsible for handling Illegal Type exception
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalException(IllegalArgumentException ex){
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
    }

    //this handler is responsible for handling all exception
//    @ExceptionHandler({IllegalArgumentException.class, CustomException.class})
//    public ResponseEntity<String> handleAllException(Exception ex){
//        return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
//    }
}
