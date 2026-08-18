package com.collegemanagement.service;

import com.collegemanagement.dto.FacultyDTO;
import com.collegemanagement.entity.Faculty;
import com.collegemanagement.repository.FacultyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public FacultyDTO createFaculty(FacultyDTO facultyDTO){
        Faculty faculty = mapToEntity(facultyDTO);
        Faculty savedFaculty = facultyRepository.save(faculty);
        return mapToDTO(savedFaculty);
    }

    public List<FacultyDTO> getAllFaculties(){
        return facultyRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public FacultyDTO getFacultyById(Long id){
        return facultyRepository.findById(id).map(this::mapToDTO).orElse(null);
    }

    public FacultyDTO updateFaculty(Long id, FacultyDTO facultyDTO){
        Faculty faculty = facultyRepository.findById(id).orElse(null);
        if(faculty == null)
            return null;

        faculty.setName(facultyDTO.getName());
        faculty.setEmail(facultyDTO.getEmail());
        faculty.setDepartment(facultyDTO.getDepartment());
        faculty.setDesignation(facultyDTO.getDesignation());
        faculty.setSalary(facultyDTO.getSalary());

        Faculty updatedFaculty = facultyRepository.save(faculty);
        return mapToDTO(updatedFaculty);
    }

    public boolean deleteFaculty(Long id){
        if(facultyRepository.existsById(id)){
            facultyRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private FacultyDTO mapToDTO(Faculty faculty){
        return new FacultyDTO(
            faculty.getId(),
            faculty.getName(),
            faculty.getEmail(),
            faculty.getDepartment(),
            faculty.getDesignation(),
            faculty.getSalary()
        );
    }

    private Faculty mapToEntity(FacultyDTO dto){
        Faculty faculty = new Faculty();
        faculty.setId(dto.getId());
        faculty.setName(dto.getName());
        faculty.setEmail(dto.getEmail());
        faculty.setDepartment(dto.getDepartment());
        faculty.setDesignation(dto.getDesignation());
        faculty.setSalary(dto.getSalary());
        return faculty;
    }
}