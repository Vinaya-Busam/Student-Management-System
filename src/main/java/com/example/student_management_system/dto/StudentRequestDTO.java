package com.example.student_management_system.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequestDTO {

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @Email(message = "Invalid Email")
    @NotBlank(message = "Email cannot be empty")   
    private String email;

    @Min(value=18, message = "Age must be at least 18")
    @Max(value=60, message = "Age must be less than 60")
    private int age;

}