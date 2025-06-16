package com.example.blog.controller;

import com.example.blog.model.Post;
import com.example.blog.service.CategoryService;
import com.example.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("")
public class PostController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private PostService postService;

    @GetMapping("")
    public String home() {
        return "redirect:/post";
    }
    @GetMapping("/post")
    public String showPosts(Model model) {
        model.addAttribute("posts", postService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        return "post/list";
    }
    @GetMapping("/post/add")
    public String showAddPostForm(Model model) {
        model.addAttribute("post", new Post());
        model.addAttribute("categories", categoryService.findAll());
        return "post/add";
    }
    @GetMapping("/edit/{id}")
    public String showEditPostForm(@PathVariable("id") int id, Model model) {
        Post post = postService.findById(id);
        model.addAttribute("post", post);
        model.addAttribute("categories", categoryService.findAll());
        return "post/edit";
    }
    @PostMapping("/edit/{id}")
    public String updatePost(@PathVariable("id") int id, @ModelAttribute Post post, RedirectAttributes redirectAttributes) {
        post.setId(id);
        postService.add(post);
        redirectAttributes.addFlashAttribute("success", "Bài viết đã được cập nhật!");
        return "redirect:/post";
    }
    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        postService.deleteById(id);
        redirectAttributes.addFlashAttribute("success", "Bài viết đã bị xóa!");
        return "redirect:/post";
    }
    @GetMapping("/posts/{id}")
    public String viewPost(@PathVariable("id") int id, Model model) {
        model.addAttribute("post", postService.findById(id));
        return "post/views";
    }
    @GetMapping("/posts/search")
    public String searchPosts(@RequestParam("keyword") String keyword, Model model) {
        model.addAttribute("posts", postService.findByTitle(keyword));
        return "post/list";
    }
    @PostMapping("/post/add")
    public String addPost(@ModelAttribute Post post, RedirectAttributes redirectAttributes) {
        postService.add(post);
        redirectAttributes.addFlashAttribute("success", "Bài viết đã được thêm!");
        return "redirect:/post";
    }
}
