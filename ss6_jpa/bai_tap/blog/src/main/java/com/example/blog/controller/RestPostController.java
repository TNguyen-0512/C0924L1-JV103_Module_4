package com.example.blog.controller;

import com.example.blog.model.Post;
import com.example.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/posts")
public class RestPostController {

    @Autowired
    private PostService postService;

    @GetMapping("")
    public ResponseEntity<Page<Post>> getAllPosts(@PageableDefault(page = 0, size = 3) Pageable pageable) {
        Page<Post> posts = postService.findAll(pageable);
        if (posts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    // GET: find by ID
    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        Optional<Post> post = postService.findById(id);
        return post.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // POST: create new post
    @PostMapping("")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post savedPost = postService.add(post);
        return new ResponseEntity<>(savedPost, HttpStatus.CREATED);
    }

    // PUT: update post
    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post post) {
        Optional<Post> existingPost = postService.findById(id);
        if (!existingPost.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        post.setId(Math.toIntExact(id)); // Đảm bảo ID đúng khi update
        Post updatedPost = postService.update(post);
        return new ResponseEntity<>(updatedPost, HttpStatus.OK);
    }

    // DELETE: delete post
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        Optional<Post> existingPost = postService.findById(id);
        if (!existingPost.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        postService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
