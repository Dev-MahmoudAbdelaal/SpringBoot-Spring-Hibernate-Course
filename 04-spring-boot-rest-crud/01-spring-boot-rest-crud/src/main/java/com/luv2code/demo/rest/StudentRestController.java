package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudents;

    //define @postConstruct to load the student data ... only once!
    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();
        theStudents.add(new Student("mahmoud", "Abdelaal"));
        theStudents.add(new Student("Omar", "Ahmed"));
        theStudents.add(new Student("Ali", "Mostafa"));

    }

    //define endpoint for "/students" -return a list of students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;

    }

    // define endpokint or "/students/{studentId}"- return student at index

    @GetMapping("students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        // just index into the list ... Keep it simple for now
        // check the studentId again list size
        if (studentId >= theStudents.size() || studentId < 0) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return theStudents.get(studentId);
    }



}
