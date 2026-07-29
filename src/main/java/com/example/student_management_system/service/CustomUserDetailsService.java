package com.example.student_management_system.service;

import com.example.student_management_system.repository.UserRepo;
import com.example.student_management_system.model.User;

import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepo userRepo;

    public CustomUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override 
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User dbUser = userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "User not found with username: " + username));
        
        
        return org.springframework.security.core.userdetails.User.builder()
            .username(dbUser.getUsername())
            .password(dbUser.getPassword())
            .roles(dbUser.getRole())
            .build();
    }
}
