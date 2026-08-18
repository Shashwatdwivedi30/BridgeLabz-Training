package com.collegemanagement.controller;

import com.collegemanagement.dto.FacultyDTO;
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
class FacultyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreateAndGetFaculty() throws Exception {
        FacultyDTO facultyDTO = new FacultyDTO(
                null,
                "Dr. Robert Davis",
                "robert.davis@college.edu",
                "Physics",
                "Associate Professor",
                85000.0
        );

        // Test POST (Create)
        String response = mockMvc.perform(post("/api/faculties")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(facultyDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").value("Dr. Robert Davis"))
                .andExpect(jsonPath("$.email").value("robert.davis@college.edu"))
                .andReturn()
                .getResponse()
                .getContentAsString();

        FacultyDTO created = objectMapper.readValue(response, FacultyDTO.class);

        // Test GET by ID
        mockMvc.perform(get("/api/faculties/" + created.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Dr. Robert Davis"));

        // Test GET all
        mockMvc.perform(get("/api/faculties"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());

        // Test PUT (Update)
        created.setDesignation("Professor");
        mockMvc.perform(put("/api/faculties/" + created.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(created)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.designation").value("Professor"));

        // Test DELETE
        mockMvc.perform(delete("/api/faculties/" + created.getId()))
                .andExpect(status().isOk());

        // Test GET after DELETE (Should return 404)
        mockMvc.perform(get("/api/faculties/" + created.getId()))
                .andExpect(status().isNotFound());
    }
}
