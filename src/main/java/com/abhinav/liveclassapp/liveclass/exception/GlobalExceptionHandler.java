package com.abhinav.liveclassapp.liveclass.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ScheduleConflictException.class)
    public String handleScheduleConflict(ScheduleConflictException e){
        return "Application ran through an Error: " + e.getMessage();
    }
}
