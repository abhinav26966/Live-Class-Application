package com.abhinav.liveclassapp.liveclass.exception;

public class ScheduleConflictException extends  RuntimeException{
    public ScheduleConflictException(String message){
        super(message);
    }
}
