package com.example.blog.service;

import com.example.blog.model.Category;
import com.example.blog.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository repository;

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public void add(Category category) {
        repository.save(category);
    }

    @Override
    public Category findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void update(Category category) {
        repository.save(category);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
