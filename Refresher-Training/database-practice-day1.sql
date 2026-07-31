create database if not exists health_clinic_db;

USE health_clinic_db;
CREATE TABLE patients (patient_id INT AUTO_INCREMENT PRIMARY KEY,name VARCHAR(20) NOT NULL, dob DATE, gender ENUM('Male', 'Female', 'Other'));

CREATE TABLE doctors (doctor_id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(20) NOT NULL, specialization VARCHAR(20), phone_number VARCHAR(15) UNIQUE);

INSERT INTO patients (name, dob, gender) VALUES ('Aviral Dwivedi', '1999-12-14', 'Male'),
('Shashwat Dwivedi', '2003-10-21', 'Male'),
('Shyam Parashar', '2004-03-19', 'Male');

INSERT INTO doctors (name, specialization, phone_number) VALUES ('Aarya Mani', 'Cardiology', '9123456780'),
('Vikram Iyer', 'Pediatrics', '9123456781'),
('Dipika Sharma', 'Pulmonologist', '8090401111');

SELECT * FROM patients;
SELECT * FROM doctors;

CREATE TABLE specializations (id INT, name VARCHAR(20), description VARCHAR(50));

CREATE TABLE appointments (id INT AUTO_INCREMENT PRIMARY KEY, patient_id INT, doctor_id INT, appointment_date DATE);

INSERT INTO specializations (id, name, description) VALUES (1, 'Cardiology', 'Heart specialist'),
(2, 'Pediatrics', 'Child healthcare specialist'),
(3, 'Pulmonologist', 'Lung and respiratory specialist');

INSERT INTO appointments (patient_id, doctor_id, appointment_date) VALUES (1, 1, '2026-08-05'),
(2, 2, '2026-08-06'),
(3, 3, '2026-08-07');

ALTER TABLE specializations ADD COLUMN department_head VARCHAR(20);
ALTER TABLE specializations DROP COLUMN department_head;

ALTER TABLE appointments ADD COLUMN status VARCHAR(20);
ALTER TABLE appointments DROP COLUMN status;

SELECT * from patients WHERE patient_id = 2;
UPDATE patients SET name = "Shashwat D." WHERE patient_id = 2;
SELECT * from patients WHERE patient_id = 2;

SELECT * FROM appointments WHERE id = 3;
DELETE FROM appointments WHERE id = 3;
SELECT * FROM appointments WHERE id = 3;

CREATE USER 'clinic_app_user'@'localhost' IDENTIFIED BY 'Clinic';
GRANT SELECT, INSERT, UPDATE, DELETE ON health_clinic_db.* TO 'clinic_app_user'@'localhost';
FLUSH PRIVILEGES;