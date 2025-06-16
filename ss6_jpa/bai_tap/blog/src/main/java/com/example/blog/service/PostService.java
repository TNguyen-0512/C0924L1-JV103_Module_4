package com.example.blog.service;

import com.example.blog.model.Post;
import com.example.blog.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements IPostService {
    @Autowired
    private IPostRepository repository;
    @Override
    public List<Post> findAll() {
        return repository.findAll();
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
    public Post findByTitle(String title) {
        return repository.findAll().stream()
                .filter(post -> post.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }
}
