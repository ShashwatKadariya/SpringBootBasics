package com.demo.quiz.DemoQuizApp.controller;


import com.demo.quiz.DemoQuizApp.dto.CategoryDTO;
import com.demo.quiz.DemoQuizApp.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<List<CategoryDTO>> findAllCategories() {
        return categoryService.findAllCategories();
    }

    @PostMapping("")
    public ResponseEntity<CategoryDTO> addCategory(@Valid @RequestBody CategoryDTO category) {
        return categoryService.addCategory(category);
    }
}
