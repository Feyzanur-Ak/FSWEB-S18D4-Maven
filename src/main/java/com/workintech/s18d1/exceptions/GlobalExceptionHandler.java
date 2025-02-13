package com.workintech.s18d1.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler
    private ResponseEntity<BurgerErrorResponse> burgerHandlerException (BurgerException burgerException){
        BurgerErrorResponse errorResponse=new BurgerErrorResponse(burgerException.getHttpStatus().value(),burgerException.getMessage(),System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, burgerException.getHttpStatus());
    }



}
