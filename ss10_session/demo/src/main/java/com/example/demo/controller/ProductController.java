package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("")
@SessionAttributes("cart") // Giỏ hàng lưu trong session
public class ProductController {

    @Autowired
    private ProductService productService;

    // Gán giỏ hàng mặc định nếu chưa có
    @ModelAttribute("cart")
    public Cart createCart() {
        return new Cart();
    }

    // Danh sách sản phẩm
    @GetMapping({"/products","/"})
    public String showProductList(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product/list";
    }

    @GetMapping("/products/{id}")
    public String showDetail(@PathVariable Long id, Model model) {
        Product product = productService.findById(id);
        if (product == null) {
            return "redirect:/error";
        }
        model.addAttribute("product", product);
        return "product/detail";
    }


    // Thêm vào giỏ hàng
    @GetMapping("/add-to-cart/{id}")
    public String addToCart(@PathVariable("id") Long id,
                            @ModelAttribute("cart") Cart cart,
                            HttpSession session) {
        Product product = productService.findById(id);
        if (product != null) {
            cart.add(product); // sử dụng class Cart bạn đã tạo
        }
        return "redirect:/cart/view"; // chuyển đến trang giỏ hàng
    }
}
