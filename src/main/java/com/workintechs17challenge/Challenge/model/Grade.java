package com.workintechs17challenge.Challenge.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Grade {
    private int coefficient ;
    private String note ;

    public Grade(int coefficient, String note) {
        this.coefficient = coefficient;
        this.note = note;
    }
}
