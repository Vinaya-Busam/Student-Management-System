package com.example.student_management_system.controller;

import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import com.example.student_management_system.dto.LoginRequestDTO;
import com.example.student_management_system.dto.LoginResponseDTO;
import com.example.student_management_system.service.AuthenticationService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@Valid @RequestBody LoginRequestDTO request) {
        LoginResponseDTO response = authenticationService.login(request);
        return ResponseEntity.ok(response);
    }
}
