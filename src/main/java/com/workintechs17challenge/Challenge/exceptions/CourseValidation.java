package com.workintechs17challenge.Challenge.exceptions;

import com.workintechs17challenge.Challenge.model.Course;
import org.springframework.http.HttpStatus;

import java.util.List;

public class CourseValidation {



    public static void isCourseIsNotExist(List<Course> courseList , String name){

        Course result = new Course();
        for (Course course : courseList){
            if (course.getName().equalsIgnoreCase(name)){
                throw new CourseException("Course is not exist" , HttpStatus.NOT_FOUND);
            }
        }
    }

    public static void isCourseCredentialValid(Course course){
        if (course == null || course.getName() == null || course.getName().isEmpty() ||
            course.getCredit()<=0 || course.getGrade().getCoefficient()<=0 || course.getGrade().getNote()==null||
                course.getGrade().getNote().isEmpty()
        ){
            throw new CourseException("Course credential is not valid" , HttpStatus.BAD_REQUEST);
        }
    }





}
