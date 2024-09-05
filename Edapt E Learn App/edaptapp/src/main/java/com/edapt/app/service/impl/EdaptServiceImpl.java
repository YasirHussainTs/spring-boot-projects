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
    public EdaptDto getEdaptById(Long id) {
        Edapt edapt = edaptRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Edapt not found with id: " + id));

        return EdaptMapper.mapToEdaptDto(edapt);
    }

    @Override
    public List<EdaptDto> getAllEdapt() {
        List<Edapt> edapts = edaptRepository.findAll();
                return edapts.stream().map((edapt) -> EdaptMapper.mapToEdaptDto(edapt))
                        .collect((Collectors.toList()));

    }
}
