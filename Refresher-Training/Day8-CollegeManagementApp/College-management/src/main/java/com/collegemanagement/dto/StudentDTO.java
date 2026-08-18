package com.collegemanagement.dto;

import jakarta.validation.constraints.*;

public class StudentDTO {
    
    private Long id;

    @NotBlank(message = "Student name is required")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Department is required")
    private String department;

    @NotBlank(message = "Roll number is required")
    private String rollNumber;

    @Min(value = 0, message = "CGPA cannot be less than 0.0")
    @Max(value = 10, message = "CGPA cannot be greater than 10.0")
    private Double cgpa;

    public StudentDTO() {
    }

    public StudentDTO(Long id, String name, String email, String department, String rollNumber, Double cgpa) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.rollNumber = rollNumber;
        this.cgpa = cgpa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public Double getCgpa() {
        return cgpa;
    }

    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }
}