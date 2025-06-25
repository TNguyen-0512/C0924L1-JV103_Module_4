package com.example.blog.service;

import com.example.blog.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IPostService {
    Page<Post> findAll(Pageable pageable);

    Post add(Post post); // Trả về Post sau khi lưu

    Optional<Post> findById(Long id); // Dùng Long cho id và Optional để dễ xử lý 404

    Post update(Post post); // Trả về Post sau khi cập nhật

    void delete(Long id); // Dùng Long thay vì Integer

    Page<Post> findByTitle(String keyword, Pageable pageable);

    Page<Post> findByCategoryId(Long categoryId, Pageable pageable);

    Page<Post> findByTitleAndCategory(String keyword, Long categoryId, Pageable pageable);
}
