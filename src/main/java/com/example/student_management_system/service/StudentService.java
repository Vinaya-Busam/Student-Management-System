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
                .orElse(null);
    }

    public StudentResponseDTO update(int id, StudentRequestDTO request) {
        StudentRequestDTO st = studentRepo.findById(id).orElse(null);
        if (st != null) {
            st.setName(updatedStudentRequest.getName());
            st.setAge(updatedStudentRequest.getAge());
            st.setEmail(updatedStudentRequest.getEmail());

            return studentRepo.save(st);
        }
        return null;
    }

    public String delete(int id) {
        studentRepo.deleteById(id);
        return "Student Deleted";
    }
}
