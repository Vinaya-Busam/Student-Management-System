package com.example.student_management_system.service;

import com.example.student_management_system.model.Student;
import org.springframework.stereotype.Service;
import com.example.student_management_system.repository.StudentRepo;
import java.util.*;

@Service
public class StudentService {

    private StudentRepo studentRepo;
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }


    public Student addStudent(Student student) {
        return studentRepo.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public Student getStudentById(int id) {
        return studentRepo.findById(id).orElse(null);
    }

    public Student update(int id, Student updatedStudent) {
        Student st = studentRepo.findById(id).orElse(null);
        if (st != null) {
            st.setName(updatedStudent.getName());
            st.setAge(updatedStudent.getAge());
            st.setEmail(updatedStudent.getEmail());

            return studentRepo.save(st);
        }
        return null;
    }

    public String delete(int id) {
        studentRepo.deleteById(id);
        return "Student Deleted";
    }
}
