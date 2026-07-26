package com.example.student_management_system.repository;

import com.example.student_management_system.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface StudentRepo extends JpaRepository<Student, Integer> {
    Optional<Student> findByName(String name);
}
