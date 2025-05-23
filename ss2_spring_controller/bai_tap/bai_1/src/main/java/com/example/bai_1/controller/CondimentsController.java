package com.example.bai_1.controller;

import com.example.bai_1.model.Condiments;
import com.example.bai_1.service.ICondimentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
public class CondimentsController {
    @Autowired
    private ICondimentsService condimentsService;
    @GetMapping({"/", "/index"})
    public String showCondimentsList(Model model) {
        try {
            List<Condiments> condimentsList = condimentsService.findAll();
            model.addAttribute("condimentsList", condimentsList);
            return "index";
        } catch (Exception e) {
            model.addAttribute("error", "Không thể tải danh sách gia vị");
            return "error";
        }
    }
    @PostMapping("/save")
    public String saveSelectedCondiments(
            @RequestParam(value = "condiments", required = false) String[] condiments,
            RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("condiments", condiments);
        return "redirect:/result";
    }
}
