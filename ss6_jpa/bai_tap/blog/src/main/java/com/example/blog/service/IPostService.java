package com.example.blog.service;

import com.example.blog.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPostService {
    Page<Post> findAll(Pageable pageable);
    void add(Post post);
    Post findById(Integer id);
    void update(Post post);
    void deleteById(Integer id);
    Page<Post> findByTitle(String keyword, Pageable pageable); // ✅ Phân trang theo tiêu đề
    Page<Post> findByCategoryId(Integer categoryId, Pageable pageable); // ✅ Phân trang theo thể loại
    Page<Post> findByTitleAndCategory(String keyword, Integer categoryId, Pageable pageable); // ✅ Phân trang theo cả 2
}

