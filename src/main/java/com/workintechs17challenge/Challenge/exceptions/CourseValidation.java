package com.workintechs17challenge.Challenge.exceptions;

import org.springframework.http.HttpStatus;

public class CourseValidation {




    public static void nameIsNotValid (String name){
        if (name==null && name.isEmpty()){
            throw new CourseException("Course name cannot be empty or null", HttpStatus.BAD_REQUEST);
        }
    }


}
