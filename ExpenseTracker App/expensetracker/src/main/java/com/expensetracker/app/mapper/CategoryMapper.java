package com.expensetracker.app.mapper;

import com.expensetracker.app.dto.CategoryDto;
import com.expensetracker.app.entity.Category;

public class CategoryMapper {

    //CategoryDto to CategoryEntity

    public static Category mapToCategory(CategoryDto categoryDto) {

        return new Category(
                categoryDto.id(),
                categoryDto.name()
        );
    }

    //CategoryEntity to CategoryDto
    public static CategoryDto maptToCategoryDto(Category category){

        return new CategoryDto(
                category.getId(),
                category.getName()
        );
    }
}
