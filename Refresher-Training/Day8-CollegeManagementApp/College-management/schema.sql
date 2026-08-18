-- ============================================================
-- SQL script for manually creating tables in MySQL
-- ============================================================

CREATE DATABASE IF NOT EXISTS college_db;
USE college_db;

-- 1. Students Table
CREATE TABLE IF NOT EXISTS students (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    department VARCHAR(100) NOT NULL,
    roll_number VARCHAR(50) NOT NULL UNIQUE,
    cgpa DOUBLE
);

-- 2. Faculties Table
CREATE TABLE IF NOT EXISTS faculties (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    department VARCHAR(100) NOT NULL,
    designation VARCHAR(100) NOT NULL,
    salary DOUBLE
);

-- Sample Seed Data for Students
INSERT INTO students (name, email, department, roll_number, cgpa)
VALUES 
('John Doe', 'john.doe@college.edu', 'Computer Science', 'CS2026001', 3.85),
('Jane Smith', 'jane.smith@college.edu', 'Electrical Engineering', 'EE2026002', 3.92)
ON DUPLICATE KEY UPDATE name=name;

-- Sample Seed Data for Faculty
INSERT INTO faculties (name, email, department, designation, salary)
VALUES 
('Dr. Alan Turing', 'alan.turing@college.edu', 'Computer Science', 'Professor', 95000.0),
('Dr. Marie Curie', 'marie.curie@college.edu', 'Physics', 'Associate Professor', 88000.0)
ON DUPLICATE KEY UPDATE name=name;
