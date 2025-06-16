package com.example.blog.service;

import com.example.blog.model.Post;

import java.util.List;

public interface IPostService {
    List<Post> findAll();
    void add(Post post);
    Post findById(Integer id);
    void update(Post post);
    void deleteById(Integer id);
    Post findByTitle(String title);

}
