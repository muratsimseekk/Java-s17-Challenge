package com.workintechs17challenge.Challenge.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Course {
    private String name;
    private int credit ;
    private Grade grade;
}
