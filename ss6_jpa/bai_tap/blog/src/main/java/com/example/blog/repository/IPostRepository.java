package com.example.blog.repository;

import com.example.blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPostRepository extends JpaRepository<Post, Integer> {
    Page<Post> findByTitleContainingIgnoreCase(String keyword, Pageable pageable);

    Page<Post> findByCategoryId(Integer categoryId, Pageable pageable);

    Page<Post> findByTitleContainingIgnoreCaseAndCategory_Id(String keyword, Integer categoryId, Pageable pageable);
}
