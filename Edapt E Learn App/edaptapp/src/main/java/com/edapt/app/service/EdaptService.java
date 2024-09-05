package com.edapt.app.service;

import com.edapt.app.dto.EdaptDto;

import java.util.List;

public interface EdaptService {

    void createStudent(EdaptDto edaptDto);

    EdaptDto getStudentById(Long id);

    List<EdaptDto> getAllStudents();

    void updateStudent(EdaptDto edaptDto);

    void deleteStudent(Long edaptId);
}
