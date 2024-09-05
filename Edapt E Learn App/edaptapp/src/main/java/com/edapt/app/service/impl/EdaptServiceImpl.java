package com.edapt.app.service.impl;

import com.edapt.app.dto.EdaptDto;
import com.edapt.app.entity.Edapt;
import com.edapt.app.mapper.EdaptMapper;
import com.edapt.app.repository.EdaptRepository;
import com.edapt.app.service.EdaptService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class EdaptServiceImpl implements EdaptService {
    private EdaptRepository edaptRepository;

    @Override
    public void createStudent(EdaptDto edaptDto) {
            Edapt edapt = EdaptMapper.mapToEdapt(edaptDto);
            edaptRepository.save(edapt);
    }

    @Override
    public EdaptDto getStudentById(Long id) {
        Edapt updatedEdapt = edaptRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Could not found Id with id " + id));
        return EdaptMapper.mapToEdaptDto(updatedEdapt);
    }

    @Override
    public List<EdaptDto> getAllStudents() {
        List<Edapt> edapts = edaptRepository.findAll();
        List<EdaptDto> edaptDtos = edapts.stream()
                .map((edapt) -> EdaptMapper.mapToEdaptDto(edapt))
                .collect(Collectors.toList());
        return edaptDtos;
    }

    @Override
    public void updateStudent(EdaptDto edaptDto) {
        edaptRepository.save(EdaptMapper.mapToEdapt(edaptDto));
    }

    @Override
    public void deleteStudent(Long edaptId) {
        edaptRepository.deleteById(edaptId);
    }
}
