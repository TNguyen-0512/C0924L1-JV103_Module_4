package com.example.bai_2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorController {
    @GetMapping({"/", "/index"})
    public String showForm(Model model) {
        return "index";
    }
    @PostMapping("/caculator")
    public String calculate(@RequestParam double numA,
                            @RequestParam double numB,
                            @RequestParam String operator,
                            Model model) {

        double result = 0;
        String message = "";

        switch (operator) {
            case "+":
                result = numA + numB;
                message = "Addition";
                break;
            case "-":
                result = numA - numB;
                message = "Subtraction";
                break;
            case "*":
                result = numA * numB;
                message = "Multiplication";
                break;
            case "/":
                if (numB == 0) {
                    message = "Error: Division by zero!";
                    model.addAttribute("error", message);
                    return "index";
                }
                result = numA / numB;
                message = "Division";
                break;
        }

        model.addAttribute("result", result);
        model.addAttribute("message", message);
        return "index";
    }
}
