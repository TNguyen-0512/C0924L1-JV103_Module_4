package com.example.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO implements Validator {

    private String name;
    private String description;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CategoryDTO catagoriesDto = (CategoryDTO) target;

        if (catagoriesDto.getName() == null || catagoriesDto.getName().isEmpty()) {
            errors.rejectValue("name", "name.empty", "Tên danh mục không được để trống");
        }
        if (catagoriesDto.getDescription() == null || catagoriesDto.getDescription().isEmpty()) {
            errors.rejectValue("description", "description.empty", "Mô tả không được để trống");
        }
    }
}
