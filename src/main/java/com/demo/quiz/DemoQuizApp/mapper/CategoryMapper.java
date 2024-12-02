package com.demo.quiz.DemoQuizApp.mapper;

import com.demo.quiz.DemoQuizApp.dto.CategoryDTO;
import com.demo.quiz.DemoQuizApp.model.Category;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryMapper {
    public static Category toEntity(CategoryDTO categoryDTO) {
        return new Category(categoryDTO.getName());
    }

    public static List<CategoryDTO> toDTO(List<Category> categories) {
        return categories.stream().map(CategoryMapper::toDTO).collect(Collectors.toList());
    }
    public static CategoryDTO toDTO(Category category) {
        return new CategoryDTO(category.getName());
    }
}
