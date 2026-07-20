package com.example.student_management_system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/student")
public class HelloController {

    @GetMapping("/hello")
    public String greet() {
        return "Hello World!!";
    }

    @PostMapping("/add")
    public String add() {
        return "Student Added";
    }

    @PutMapping("/update")
    public String update() {
        return "Updated";
    }

    @DeleteMapping("/delete")
    public String delete() {
        return "Deleted";
    }
}