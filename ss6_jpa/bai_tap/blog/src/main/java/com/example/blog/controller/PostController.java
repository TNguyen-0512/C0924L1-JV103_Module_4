package com.example.blog.controller;

import com.example.blog.model.Post;
import com.example.blog.service.CategoryService;
import com.example.blog.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.Optional;


@Controller
@RequestMapping("")
public class PostController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private PostService postService;

    @GetMapping("/post")
    public String showPosts(HttpServletRequest request, Model model,
                            @RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 5, Sort.by(Sort.Direction.DESC, "createdAt"));
        Page<Post> posts = postService.findAll(pageable);

        model.addAttribute("posts", posts);
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("currentPage", page);
        model.addAttribute("requestURI", request.getRequestURI());
        return "post/list";
    }

    @GetMapping("/post/add")
    public String showAddPostForm(Model model) {
        model.addAttribute("post", new Post());
        model.addAttribute("categories", categoryService.findAll());
        return "post/add";
    }
    @GetMapping("/edit/{id}")
    public String showEditPostForm(@PathVariable("id") long id, Model model) {
        Optional<Post> post = postService.findById(id);
        if (post.isPresent()) {
            model.addAttribute("post", post.get()); // ✅ Truyền đúng Post
            model.addAttribute("categories", categoryService.findAll());
            return "post/edit";
        } else {
            return "redirect:/post"; // hoặc trả về trang lỗi
        }
    }
    @PostMapping("/edit/{id}")
    public String updatePost(@PathVariable("id") int id, @ModelAttribute Post post, RedirectAttributes redirectAttributes) {
       post.setId(id);
        postService.add(post);
        redirectAttributes.addFlashAttribute("success", "Bài viết đã được cập nhật!");
        return "redirect:/post";
    }
    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable("id") long id, RedirectAttributes redirectAttributes) {
        postService.delete(id);
        redirectAttributes.addFlashAttribute("success", "Bài viết đã bị xóa!");
        return "redirect:/post";
    }
    @GetMapping("/post/{id}")
    public String viewPost(@PathVariable("id") long id, Model model) {
        Optional<Post> post = postService.findById(id);
        if (post.isPresent()) {
            model.addAttribute("post", post.get());
            return "post/views";
        } else {
            return "redirect:/post"; // hoặc trả về trang lỗi tùy bạn
        }
    }

    @GetMapping("/post/search")
    public String searchPosts(@RequestParam(value = "keyword", required = false) String keyword,
                              @RequestParam(value = "categoryId", required = false) Long categoryId,
                              @RequestParam(value = "page", defaultValue = "0") int page,
                              Model model) {

        Pageable pageable = PageRequest.of(page, 5);
        Page<Post> posts;

        if ((keyword == null || keyword.isEmpty()) && categoryId == null) {
            posts = postService.findAll(pageable);
        } else if (keyword != null && !keyword.isEmpty() && categoryId != null) {
            posts = postService.findByTitleAndCategory(keyword, categoryId, pageable);
        } else if (keyword != null && !keyword.isEmpty()) {
            posts = postService.findByTitle(keyword, pageable);
        } else {
            posts = postService.findByCategoryId(categoryId, pageable);
        }

        model.addAttribute("posts", posts);
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        model.addAttribute("categoryId", categoryId);

        return "post/list";
    }

    @PostMapping("/post/add")
    public String addPost(@ModelAttribute Post post, RedirectAttributes redirectAttributes) {
        post.setCreatedAt(LocalDateTime.now());
        postService.add(post);
        redirectAttributes.addFlashAttribute("success", "Bài viết đã được thêm!");
        return "redirect:/post";
    }
}
