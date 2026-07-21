package com.example.student_management_system.service;

import com.example.student_management_system.model.Student;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class StudentService {

    private ArrayList<Student> students = new ArrayList<>();

    public Student addStudent(Student student) {
        students.add(student); 
        return student;
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public Student getStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }
}
