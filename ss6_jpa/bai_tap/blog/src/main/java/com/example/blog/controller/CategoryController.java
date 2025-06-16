package com.example.blog.controller;

import com.example.blog.model.Category;
import com.example.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // Hiển thị danh sách thể loại
    @GetMapping
    public String listCategories(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "category/list";
    }

    // Hiển thị form thêm mới
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("category", new Category());
        return "category/add";
    }

    // Xử lý thêm mới
    @PostMapping("/add")
    public String addCategory(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {
        categoryService.add(category);
        redirectAttributes.addFlashAttribute("success", "Thêm thể loại thành công!");
        return "redirect:/category";
    }

    // Hiển thị form chỉnh sửa
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Category category = categoryService.findById(id);
        if (category == null) {
            return "redirect:/category";
        }
        model.addAttribute("category", category);
        return "category/edit";
    }

    // Xử lý cập nhật
    @PostMapping("/edit")
    public String updateCategory(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {
        categoryService.update(category);
        redirectAttributes.addFlashAttribute("success", "Cập nhật thể loại thành công!");
        return "redirect:/category";
    }

    // Xoá thể loại
    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        categoryService.deleteById(id);
        redirectAttributes.addFlashAttribute("success", "Xoá thể loại thành công!");
        return "redirect:/category";
    }
}
