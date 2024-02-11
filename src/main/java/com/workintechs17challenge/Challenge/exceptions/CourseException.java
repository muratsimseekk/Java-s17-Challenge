package com.workintechs17challenge.Challenge.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;
//@Data ile tum getter setter lari CourseController icerisinde kullan.
@Data
public class CourseException extends RuntimeException{

    private HttpStatus httpStatus;
    public CourseException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
