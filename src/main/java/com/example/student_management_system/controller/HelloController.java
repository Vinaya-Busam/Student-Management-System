package com.example.student_management_system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class HelloController {

    @GetMapping("/hello")
    public String greet() {
        return "Hello World!!";
    }

    @GetMapping("/about")
    public String about() {
        return "This is about Student Management System";
    }
}