package com.demo.quiz.DemoQuizApp.repository;

import com.demo.quiz.DemoQuizApp.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRespository extends JpaRepository<Category, String> {
    Optional<Object> findByName(String name);
}