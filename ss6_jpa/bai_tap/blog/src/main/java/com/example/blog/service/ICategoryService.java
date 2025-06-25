package com.example.blog.service;

import com.example.blog.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> findAll();
    Category save(Category category); // dùng cho cả thêm và sửa
    Optional<Category> findById(Long id);
    void delete(Long id);
}
