package com.example.student_management_system.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @Min(value=18, message = "Age must be atleast 18")
    @Max(value=60, message = "Age must be less than 60")
    private int age;

    @Email(message = "Invalid Email")
    @NotBlank(message = "Email cannot be empty")
    private String email;

}
