package com.edapt.app.mapper;

import com.edapt.app.dto.EdaptDto;
import com.edapt.app.entity.Edapt;

public class EdaptMapper {

    public static Edapt mapToEdapt(EdaptDto edaptDto) {
        Edapt edapt = new Edapt(
                edaptDto.getId(),
                edaptDto.getName()
        );
        return edapt;
    }

    public static EdaptDto mapToEdaptDto(Edapt edapt){
        EdaptDto edaptDto = new EdaptDto(
                edapt.getId(),
                edapt.getName()
        );
        return edaptDto;
    }
}
