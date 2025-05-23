package com.example.chuyen_doi_tien_te.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    private static final double TYLE = 25.973;
    @GetMapping("/")
    public String home() {
        return "index";
    }
    @PostMapping("/doi")
    public String doi(@RequestParam("rate") double rate,@RequestParam("usd") double usd, Model model) {
        double vnd = usd * rate;
        model.addAttribute("vnd", vnd);
        model.addAttribute("rate", rate);
        model.addAttribute("usd", usd);
        return "index";
    }
}

