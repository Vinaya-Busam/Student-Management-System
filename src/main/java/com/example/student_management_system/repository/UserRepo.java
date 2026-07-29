package com.example.student_management_system.repository;

import com.example.student_management_system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.*;

public interface UserRepo extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);
}
