package com.workintechs17challenge.Challenge.controller;

import com.workintechs17challenge.Challenge.model.Course;
import com.workintechs17challenge.Challenge.model.CourseGpa;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("workintech")
public class CourseController {
    List<Course> courses ;
    private CourseGpa courseGpa1;
    private CourseGpa courseGpa2;
    private CourseGpa courseGpa3;

    @PostConstruct
    public void init(){
        courses = new ArrayList<>();
    }

    // 1 den fazla CourseGpa implements eden Class var o yuzden Qualifier ile bagliyoruz.
    @Autowired
    public CourseController (@Qualifier("highCourseGpa") CourseGpa courseGpa1 ,
                             @Qualifier("mediumCourseGpa") CourseGpa courseGpa2,
                             @Qualifier("lowCourseGpa") CourseGpa courseGpa3
                             ){
        this.courseGpa1=courseGpa1;
        this.courseGpa2=courseGpa2;
        this.courseGpa3= courseGpa3;
    }

    @GetMapping("/courses")
    public List<Course> getCourses (){
        return courses;
    }

    @GetMapping("/courses/{name}")
    public Course getCourseByName(@PathVariable String name){
        Course result = new Course();
        for (Course course : courses){
            if (course.getName().equalsIgnoreCase(name)){
                result = course;
            }
        }
        return result;
    }
    @PostMapping("/courses")
    public Course saveNewCourse(@RequestBody Course course){
        int totalGpa = 0;
        courses.add(course);
        if (course.getCredit() <=2){
            totalGpa = course.getGrade().getCoefficient() * course.getCredit()* courseGpa3.getGpa();
            System.out.println("Total Gpa : " + totalGpa);
        } else if (course.getCredit() ==3 ) {
            totalGpa = course.getGrade().getCoefficient() * course.getCredit() * courseGpa2.getGpa();
            System.out.println("Total Gpa : " + totalGpa);
        } else if (course.getCredit() == 4) {
            totalGpa = course.getGrade().getCoefficient() * course.getCredit() * courseGpa1.getGpa();
            System.out.println("Total Gpa : " + totalGpa);
        }
        return course;
    }
    @PutMapping("/courses/{name}")
    public Course updateCourse (@RequestBody Course course , @PathVariable String name){
        for (Course course1 : courses){
            if (course1.getName().equalsIgnoreCase(name)){
                course1.setName(course.getName());
                course1.setCredit(course.getCredit());
                course1.setGrade(course.getGrade());
            }
        }
        //TODO totalGpa degerini return et.
        return course;
    }
    @DeleteMapping("/courses/{name}")
    public void remove(@PathVariable String name){
        for (Course course1 : courses){
            if (course1.getName().equalsIgnoreCase(name)){
                courses.remove(course1);
                System.out.println(course1 + " kursu silindi . ");
            }
        }

    }
}
