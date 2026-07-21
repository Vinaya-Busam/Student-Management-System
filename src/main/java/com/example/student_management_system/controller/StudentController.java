package com.example.student_management_system.controller;

import com.example.student_management_system.model.Student;
import com.example.student_management_system.service.StudentService;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/hello")
    public String greet() {
        return "Hello World!!";
    }

    @PostMapping("/add")
    public Student add(@RequestBody Student student) {
        return studentService.addStudent(student); 

    }

    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/getStudent/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/update/{id}")
    public Student update(@PathVariable int id, @RequestBody Student updatedStudent) {
        return studentService.update(id, updatedStudent);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        return studentService.delete(id);
    }

}