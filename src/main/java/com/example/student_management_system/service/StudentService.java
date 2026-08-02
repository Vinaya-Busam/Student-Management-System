package com.example.student_management_system.service;

import com.example.student_management_system.dto.StudentResponseDTO;
import com.example.student_management_system.model.Student;
import org.springframework.stereotype.Service;
import com.example.student_management_system.repository.StudentRepo;
import com.example.student_management_system.dto.StudentResponseDTO;
import com.example.student_management_system.dto.StudentRequestDTO;
import com.example.student_management_system.exception.StudentNotFoundException;

import java.util.*;

@Service
public class StudentService {

    private StudentRepo studentRepo;
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    // Helper method to map Student entity to StudentResponseDTO
    private StudentResponseDTO mapToResponseDTO(Student student) {

        return new StudentResponseDTO(
                student.getId(),
                student.getName(),
                student.getEmail()
        );
    }


    public StudentResponseDTO addStudent(StudentRequestDTO studentRequest) {
        Student student = new Student();
        student.setName(studentRequest.getName());
        student.setAge(studentRequest.getAge());
        student.setEmail(studentRequest.getEmail());
        Student savedStudent = studentRepo.save(student);
        return mapToResponseDTO(savedStudent);
    }

    public List<StudentResponseDTO> getAllStudents() {
        return studentRepo.findAll().stream()
                .map(this::mapToResponseDTO)
                .toList();
    }

    public StudentResponseDTO getStudentById(int id) {
        return studentRepo.findById(id)
                .map(this::mapToResponseDTO)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
    }

    public StudentResponseDTO getStudentByName(String name) {
        return studentRepo.findByName(name)
                .map(this::mapToResponseDTO)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with name: " + name));
    }

    public StudentResponseDTO update(int id, StudentRequestDTO request) {
        Student st = studentRepo.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
       
        st.setName(request.getName());
        st.setAge(request.getAge());
        st.setEmail(request.getEmail());
        
        Student updated = studentRepo.save(st);

        return mapToResponseDTO(updated);
    }

    public String delete(int id) {
        studentRepo.deleteById(id);
        return "Student Deleted";
    }


    public List<StudentResponseDTO> findStudentOlderThan(int age) {
        List<Student> students = studentRepo.findStudentsOlderThan(age);
        return students.stream()
                .map(this::mapToResponseDTO)
                .toList();
    }
}
