# College Management System (Spring Boot CRUD API)

A simple, clean, and modular Spring Boot REST API for performing CRUD operations on **Student** and **Faculty** records.

---

## 📁 Project Folder Structure

```
d:/College-management/
├── pom.xml
├── schema.sql
├── README.md
└── src/
    ├── main/
    │   ├── java/com/collegemanagement/
    │   │   ├── CollegeManagementApplication.java  # Main Application Class
    │   │   ├── controller/                         # REST API Controllers
    │   │   │   ├── StudentController.java
    │   │   │   └── FacultyController.java
    │   │   ├── dto/                                # Data Transfer Objects (DTO)
    │   │   │   ├── StudentDTO.java
    │   │   │   └── FacultyDTO.java
    │   │   ├── entity/                             # JPA Entities
    │   │   │   ├── Student.java
    │   │   │   └── Faculty.java
    │   │   ├── repository/                         # JPA Repositories
    │   │   │   ├── StudentRepository.java
    │   │   │   └── FacultyRepository.java
    │   │   └── service/                            # Service Layer (CRUD Logic)
    │   │       ├── StudentService.java
    │   │       └── FacultyService.java
    │   └── resources/
    │       └── application.properties             # Database & Server Config
    └── test/
        └── java/com/collegemanagement/
            ├── CollegeManagementApplicationTests.java
            └── controller/
                ├── StudentControllerTest.java
                └── FacultyControllerTest.java
```

---

## 🚀 How to Run the Application

### 1. Requirements
- **Java 21** (e.g. OpenJDK / Microsoft JDK 21.0.12)
- **Maven 3.8+**

### 2. Run Command
Open terminal in the project root:
```bash
mvn spring-boot:run
```

The server will start at: `http://localhost:8080`

### 3. Database Options

- **H2 In-Memory DB (Default)**: Ready to use with zero setup.
  - H2 Console: `http://localhost:8080/h2-console`
  - JDBC URL: `jdbc:h2:mem:college_db`
  - Username: `sa`
  - Password: *(leave blank)*

- **MySQL**: Uncomment MySQL properties in `src/main/resources/application.properties` and provide your MySQL credentials.

---

## 📡 REST API Endpoints

### 🎓 Student Endpoints (`/api/students`)

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/api/students` | Create student |
| `GET` | `/api/students` | Get all students |
| `GET` | `/api/students/{id}` | Get student by ID |
| `PUT` | `/api/students/{id}` | Update student by ID |
| `DELETE` | `/api/students/{id}` | Delete student by ID |

#### Sample Student Payload:
```json
{
  "name": "Alice Smith",
  "email": "alice.smith@college.edu",
  "department": "Computer Science",
  "rollNumber": "CS2026001",
  "cgpa": 3.85
}
```

---

### 👨‍🏫 Faculty Endpoints (`/api/faculties`)

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/api/faculties` | Create faculty member |
| `GET` | `/api/faculties` | Get all faculty members |
| `GET` | `/api/faculties/{id}` | Get faculty by ID |
| `PUT` | `/api/faculties/{id}` | Update faculty by ID |
| `DELETE` | `/api/faculties/{id}` | Delete faculty by ID |

#### Sample Faculty Payload:
```json
{
  "name": "Dr. Robert Davis",
  "email": "robert.davis@college.edu",
  "department": "Physics",
  "designation": "Associate Professor",
  "salary": 85000.00
}
```
