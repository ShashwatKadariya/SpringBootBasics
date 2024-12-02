package com.demo.quiz.DemoQuizApp.dto;

import com.demo.quiz.DemoQuizApp.util.LowerCaseDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CategoryDTO {
    @Valid

    @NotNull(message = "name is mandatory")
    @NotBlank(message = "name is mandatory")
    @JsonDeserialize(using = LowerCaseDeserializer.class)
    private String name;

    public CategoryDTO() {}
    public CategoryDTO(String name) {
        this.name = name;
    }
}
