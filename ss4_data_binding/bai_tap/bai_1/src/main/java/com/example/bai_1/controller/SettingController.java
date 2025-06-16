package com.example.bai_1.controller;

import com.example.bai_1.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class SettingController {
    private Email email = new Email();

    @GetMapping({"/", "/index"})
    public String showForm(Model model) {
        model.addAttribute("email", email);
        return "index";
    }

    @PostMapping("/settings")
    public String updateSettings(@ModelAttribute("setting") Email email, Model model) {
        this.email = email;
        model.addAttribute("setting", email);
        return "result";
    }

    @ModelAttribute("languages")
    public List<String> getAllLanguage() {
        return Arrays.asList("English", "Vietnamese", "Japanese", "Chinese");
    }

    @ModelAttribute("pageSizes")
    public List<Integer> getPageSizes() {
        return Arrays.asList(5, 10, 25, 50, 100);
    }

}
