package com.workintechs17challenge.Challenge.entity;

import com.workintechs17challenge.Challenge.model.CourseGpa;
import org.springframework.stereotype.Component;

@Component
public class MediumCourseGpa implements CourseGpa {
    @Override
    public int getGpa() {
        return 5;
    }
}
