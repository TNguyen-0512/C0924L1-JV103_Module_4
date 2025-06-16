package com.example.blog.service;

import com.example.blog.model.Post;
import com.example.blog.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PostService implements IPostService {

    @Autowired
    private IPostRepository repository;

    @Override
    public Page<Post> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void add(Post post) {
        repository.save(post);
    }

    @Override
    public Post findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void update(Post post) {
        repository.save(post);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Page<Post> findByTitle(String keyword, Pageable pageable) {
        return repository.findByTitleContainingIgnoreCase(keyword, pageable);
    }

    @Override
    public Page<Post> findByCategoryId(Integer categoryId, Pageable pageable) {
        return repository.findByCategoryId(categoryId, pageable);
    }

    @Override
    public Page<Post> findByTitleAndCategory(String keyword, Integer categoryId, Pageable pageable) {
        return repository.findByTitleContainingIgnoreCaseAndCategory_Id(keyword, categoryId, pageable);
    }
}
