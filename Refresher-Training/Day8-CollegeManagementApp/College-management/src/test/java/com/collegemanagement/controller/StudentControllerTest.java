package com.collegemanagement.controller;

import com.collegemanagement.dto.StudentDTO;
import com.collegemanagement.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreateAndGetStudent() throws Exception {
        StudentDTO studentDTO = new StudentDTO(
                null,
                "Alice Smith",
                "alice.smith@college.edu",
                "Computer Science",
                "CS2026001",
                3.85
        );

        // Test POST (Create)
        String response = mockMvc.perform(post("/api/students")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(studentDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").value("Alice Smith"))
                .andExpect(jsonPath("$.email").value("alice.smith@college.edu"))
                .andReturn()
                .getResponse()
                .getContentAsString();

        StudentDTO created = objectMapper.readValue(response, StudentDTO.class);

        // Test GET by ID
        mockMvc.perform(get("/api/students/" + created.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Alice Smith"));

        // Test GET all
        mockMvc.perform(get("/api/students"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());

        // Test PUT (Update)
        created.setName("Alice Updated");
        mockMvc.perform(put("/api/students/" + created.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(created)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Alice Updated"));

        // Test DELETE
        mockMvc.perform(delete("/api/students/" + created.getId()))
                .andExpect(status().isOk());

        // Test GET after DELETE (Should return 404)
        mockMvc.perform(get("/api/students/" + created.getId()))
                .andExpect(status().isNotFound());
    }
}
