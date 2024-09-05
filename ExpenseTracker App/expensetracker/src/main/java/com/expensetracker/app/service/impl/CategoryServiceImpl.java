package com.expensetracker.app.service.impl;

import com.expensetracker.app.dto.CategoryDto;
import com.expensetracker.app.entity.Category;
import com.expensetracker.app.mapper.CategoryMapper;
import com.expensetracker.app.repository.CategoryRepository;
import com.expensetracker.app.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {

        //Convert categoryDto to category entity
        Category category = CategoryMapper.mapToCategory(categoryDto);

        //save category object into DB
        Category savedCategory = categoryRepository.save(category);

        //Convert savedCategory to categoryDto
        return CategoryMapper.maptToCategoryDto(savedCategory);

    }

    @Override
    public CategoryDto getCategoryById(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category could not find with Id" + categoryId));

        return CategoryMapper.maptToCategoryDto(category);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();

        return categories.stream()
                .map((Category) -> CategoryMapper.maptToCategoryDto(Category))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto updateCategory(Long categoryId, CategoryDto categoryDto) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category could not find with Id" + categoryId));

        category.setName(categoryDto.name());
        Category updatedCategory = categoryRepository.save(category); //performs update operation
        return CategoryMapper.maptToCategoryDto(updatedCategory);
    }

    @Override
    public void deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category could not find with Id" + categoryId));
        categoryRepository.delete(category);
    }
}
