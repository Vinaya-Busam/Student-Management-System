package com.example.student_management_system.controller;

import com.example.student_management_system.model.Student;
import com.example.student_management_system.service.StudentService;
import com.example.student_management_system.dto.StudentResponseDTO;
import com.example.student_management_system.dto.StudentRequestDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "BearerAuth")
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
    public ResponseEntity<StudentResponseDTO> add(@Valid @RequestBody StudentRequestDTO request) {
        StudentResponseDTO response = studentService.addStudent(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/getAllStudents")
    public ResponseEntity<List<StudentResponseDTO>> getAllStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/getStudent/{id}")
    public ResponseEntity<StudentResponseDTO> getStudentById(@PathVariable int id) {
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }

    @GetMapping("/getStudentByName/{name}")
    public ResponseEntity<StudentResponseDTO> getStudentByName(@PathVariable String name) {
        return new ResponseEntity<>(studentService.getStudentByName(name), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StudentResponseDTO> update(@PathVariable int id, @RequestBody StudentRequestDTO updatedStudentRequest) {
        StudentResponseDTO updated = studentService.update(id, updatedStudentRequest);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        studentService.delete(id);
        return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
    }


    @GetMapping("/findOlderThan/{age}")
    public ResponseEntity<List<StudentResponseDTO>> findStudentsOlderThan(@PathVariable int age) {
        return new ResponseEntity<>(studentService.findStudentOlderThan(age), HttpStatus.OK);
    }

}