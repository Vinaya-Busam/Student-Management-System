package com.example.student_management_system.controller;

import com.example.student_management_system.model.Student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/student")
public class HelloController {

    @GetMapping("/hello")
    public String greet() {
        return "Hello World!!";
    }

    @PostMapping("/add")
    public String add(@RequestBody Student student) {
        return "Student: " + student.getName() + ", age: "
                + student.getAge() + ", Email:" 
                + student.getEmail() + " Added"; 

    }

}