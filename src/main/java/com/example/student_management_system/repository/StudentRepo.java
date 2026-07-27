package com.example.student_management_system.repository;

import com.example.student_management_system.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.*;

public interface StudentRepo extends JpaRepository<Student, Integer> {
    Optional<Student> findByName(String name);

    @Query("SELECT s FROM Student s WHERE s.age > :age")
    List<Student> findStudentsOlderThan(int age);
}
