package com.example.student_management_system.service;

import org.springframework.stereotype.Service;
import com.example.student_management_system.dto.LoginResponseDTO;
import com.example.student_management_system.dto.LoginRequestDTO;


@Service
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;
    private final CustomUserDetailsService userDetailsService;

    public AuthenticationService(AuthenticationManager authenticationManager, JWTService jwtService, 
                                CustomUserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    public LoginResponseDTO login(LoginRequestDTO request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
            )
        );

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        String token = jwtService.generateToken(userDetails);   

        return new LoginResponseDTO(token);
    }
}
