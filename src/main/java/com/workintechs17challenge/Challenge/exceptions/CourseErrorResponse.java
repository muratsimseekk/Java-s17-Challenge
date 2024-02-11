package com.workintechs17challenge.Challenge.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CourseErrorResponse {

    private Integer status;
    private String message;
    private LocalDateTime createdAt ;

}
