package com.demo.quiz.DemoQuizApp.service;


import com.demo.quiz.DemoQuizApp.dto.CategoryDTO;
import com.demo.quiz.DemoQuizApp.exception.DuplicateRecordException;
import com.demo.quiz.DemoQuizApp.mapper.CategoryMapper;
import com.demo.quiz.DemoQuizApp.model.Category;
import com.demo.quiz.DemoQuizApp.repository.CategoryRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRespository categoryRespository;
    public ResponseEntity<List<CategoryDTO>> findAllCategories() {
        return new ResponseEntity<>(
                CategoryMapper.toDTO(categoryRespository.findAll()),
                HttpStatus.OK
        );
    }

    public ResponseEntity<CategoryDTO> addCategory(CategoryDTO categoryDto) {
        Category category = CategoryMapper.toEntity(categoryDto);

        if (categoryRespository.findByName(category.getName()).isPresent()) {
            throw new DuplicateRecordException("Category name already exists");
        }

        return new ResponseEntity<>(
                CategoryMapper.toDTO( categoryRespository.save(category)),
                HttpStatus.CREATED
        );
    }
}
