package com.edapt.app.service;

import com.edapt.app.dto.EdaptDto;

import java.util.List;

public interface EdaptService {

    EdaptDto getEdaptById(Long id);

    List<EdaptDto> getAllEdapt();
}
