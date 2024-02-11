package com.workintechs17challenge.Challenge.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    public ResponseEntity<CourseErrorResponse> handleException(CourseException courseException){

        CourseErrorResponse errorResponse = new CourseErrorResponse(courseException.getHttpStatus().value(),
                courseException.getMessage(), LocalDateTime.now());

        return new ResponseEntity<>(errorResponse,courseException.getHttpStatus());
    }

    public ResponseEntity<CourseErrorResponse> handleException(Exception exception){
        CourseErrorResponse errorResponse = new CourseErrorResponse(HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(),LocalDateTime.now());

        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }

}
