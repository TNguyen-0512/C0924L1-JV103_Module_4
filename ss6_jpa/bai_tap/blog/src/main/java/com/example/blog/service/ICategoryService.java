package com.example.blog.service;

import com.example.blog.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    void add(Category category);

    Category findById(Integer id);

    void update(Category category);

    void deleteById(Integer id);

}
