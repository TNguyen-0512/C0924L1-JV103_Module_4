package com.example.blog.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDateTime;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO implements Validator {
    private String title;
    private String content;
    private String author;
    private int categoryId;
    private LocalDateTime createdAt;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        PostDTO postDto = (PostDTO) target;

        if (postDto.getTitle() == null || postDto.getTitle().isEmpty()) {
            errors.rejectValue("title", "title.empty", "Tiêu đề không được để trống");
        }
        if (postDto.getContent() == null || postDto.getContent().isEmpty()) {
            errors.rejectValue("content", "content.empty", "Nội dung không được để trống");
        }
        if (postDto.getAuthor() == null || postDto.getAuthor().isEmpty()) {
            errors.rejectValue("author", "author.empty", "Tác giả không được để trống");
        }
        if (postDto.getCategoryId() <= 0) {
            errors.rejectValue("categoryId", "categoryId.invalid", "Danh mục không hợp lệ");
        }
        if (postDto.getCreatedAt() == null) {
        }
        errors.rejectValue("createdAt", "createdAt.empty", "Ngày tạo không được để trống");
    }
}