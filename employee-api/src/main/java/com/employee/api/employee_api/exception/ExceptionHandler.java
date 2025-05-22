package com.employee.api.employee_api.exception;

import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Object> handleEmployeeNotFount(EmployeeNotFoundException ex){

        Map<String, Object> errBody = new HashMap<>();
        errBody.put("timestamp", LocalDateTime.now());
        errBody.put("status", HttpStatus.NOT_FOUND);
        errBody.put("message", ex.getMessage());

        return new ResponseEntity<>(errBody, HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception ex){
        Map<String, Object> errBody = new HashMap<>();
        errBody.put("timestamp", LocalDateTime.now());
        errBody.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
        errBody.put("message", ex.getMessage());

        return new ResponseEntity<>(errBody, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
