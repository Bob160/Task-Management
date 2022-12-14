package com.example.springtest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    protected ResponseEntity<Object> handleNotFound(ResourceNotFoundException ex) {
        ApiError apiError = new ApiError();
        apiError.setStatus(HttpStatus.NOT_FOUND);
        apiError.setMessage(ex.getMessage());
        apiError.setDebugMessage(ex.getDebugMessage());

        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }
@ExceptionHandler(InvalidRequestException.class)
    protected ResponseEntity<Object> handleInvalidRequest(InvalidRequestException ex) {
        ApiError apiError = new ApiError();
        apiError.setStatus(HttpStatus.BAD_REQUEST);
        apiError.setMessage(ex.getMessage());
        apiError.setDebugMessage(ex.getDebugMessage());

        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }
}
