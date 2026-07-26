package com.example.student_management_system.service;

import com.example.student_management_system.dto.StudentResponseDTO;
import com.example.student_management_system.model.Student;
import org.springframework.stereotype.Service;
import com.example.student_management_system.repository.StudentRepo;
import com.example.student_management_system.dto.StudentResponseDTO;
import com.example.student_management_system.dto.StudentRequestDTO;

import java.util.*;

@Service
public class StudentService {

    private StudentRepo studentRepo;
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }


    public StudentResponseDTO addStudent(StudentRequestDTO studentRequest) {
        Student student = new Student();
        student.setName(studentRequest.getName());
        student.setAge(studentRequest.getAge());
        student.setEmail(studentRequest.getEmail());
        Student savedStudent = studentRepo.save(student);
        return new StudentResponseDTO(savedStudent.getId(), savedStudent.getName(), savedStudent.getEmail());
    }

    public List<StudentResponseDTO> getAllStudents() {
        return studentRepo.findAll().stream()
                .map(student -> new StudentResponseDTO(student.getId(), student.getName(), student.getEmail()))
                .toList();
    }

    public StudentResponseDTO getStudentById(int id) {
        return studentRepo.findById(id)
                .map(student -> new StudentResponseDTO(student.getId(), student.getName(), student.getEmail()))
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public StudentResponseDTO update(int id, StudentRequestDTO request) {
        Student st = studentRepo.findById(id).orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
       
        st.setName(request.getName());
        st.setAge(request.getAge());
        st.setEmail(request.getEmail());
        
        Student updated = studentRepo.save(st);

        return new StudentResponseDTO(updated.getId(), updated.getName(), updated.getEmail());
    }

    public String delete(int id) {
        studentRepo.deleteById(id);
        return "Student Deleted";
    }
}
