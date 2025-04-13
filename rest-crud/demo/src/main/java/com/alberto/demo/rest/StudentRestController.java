package com.alberto.demo.rest;

import com.alberto.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class StudentRestController {
    //define a field
    private List<Student> theStudents;
    //create a constructor
    @PostConstruct
    public void StudentRestController() {
        //create the students
        theStudents = new ArrayList<>();
        theStudents.add(new Student("John", "Doe"));
        theStudents.add(new Student("Jane", "Perez"));
        theStudents.add(new Student("Jim", "Beam"));
    }
    //define endpoints
    @RequestMapping("/students/{studentId}")
    public  List<Student> getStudents() {
/* List<Student> students = new ArrayList<>();
        students.add(new Student("John", "Doe"));
        students.add(new Student("Jane", "Perez"));
        students.add(new Student("Jim", "Beam"));*/

        return theStudents;
    }
    //define endpoint for /students/{studentId} return student  at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        //check the index is in bounds

        if ((studentId >= theStudents.size()) || (studentId < 0)) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return theStudents.get(studentId);
    }

    //add an exception handler using @ExceptionHandler

}
