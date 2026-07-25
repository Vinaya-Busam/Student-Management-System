package com.example.student_management_system.controller;

import com.example.student_management_system.model.Student;
import com.example.student_management_system.service.StudentService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import jakarta.validation.Valid;

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
    public ResponseEntity<Student> add(@Valid @RequestBody Student student) {
        Student addedStudent = studentService.addStudent(student);
        return new ResponseEntity<>(addedStudent, HttpStatus.CREATED);
    }

    @GetMapping("/getAllStudents")
    public ResponseEntity<List<Student>> getAllStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/getStudent/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> update(@PathVariable int id, @RequestBody Student updatedStudent) {
        Student updated = studentService.update(id, updatedStudent);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        studentService.delete(id);
        return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
    }

}