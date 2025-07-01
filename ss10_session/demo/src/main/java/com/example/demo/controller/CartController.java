package com.example.demo.controller;

import com.example.demo.model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/cart")
@SessionAttributes("cart")
public class CartController {

    @ModelAttribute("cart")
    public Cart initCart() {
        return new Cart();
    }

    // Hiển thị giỏ hàng
    @GetMapping("/view")
    public ModelAndView viewCart(@ModelAttribute("cart") Cart cart) {
        ModelAndView mav = new ModelAndView("cart/view"); // /WEB-INF/views/cart/view.jsp
        mav.addObject("cart", cart);
        return mav;
    }

    // Cập nhật số lượng sản phẩm
    @PostMapping("/update")
    public String updateCart(@RequestParam("productId") Long productId,
                             @RequestParam("quantity") int quantity,
                             @ModelAttribute("cart") Cart cart) {
        if (quantity <= 0) {
            cart.remove(productId);
        } else {
            cart.update(productId, quantity);
        }
        return "redirect:/cart/view";
    }

    // Xóa sản phẩm khỏi giỏ
    @GetMapping("/remove/{id}")
    public String removeFromCart(@PathVariable("id") Long id,
                                 @ModelAttribute("cart") Cart cart) {
        cart.remove(id);
        return "redirect:/cart/view";
    }

    // Thanh toán (xoá giỏ hàng khỏi session)
    @GetMapping("/checkout")
    public String checkout(SessionStatus status) {
        status.setComplete(); // xoá session @SessionAttributes("cart")
        return "redirect:/cart/view?success";
    }
}

