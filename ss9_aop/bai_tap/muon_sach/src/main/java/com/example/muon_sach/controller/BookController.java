package com.example.muon_sach.controller;

import com.example.muon_sach.model.BorrowBook;
import com.example.muon_sach.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "book/list";
    }

    @GetMapping("/{id}")
    public String bookDetail(@PathVariable int id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        return "book/detail";
    }

    @PostMapping("/borrow/{id}")
    public String borrow(@PathVariable int id, Model model) {
        String code = bookService.borrowBook(id); // Có thể ném exception nếu quantity == 0
        model.addAttribute("code", code);
        return "book/borrow_success";
    }

    @GetMapping("/return")
    public String returnForm() {
        return "book/return";
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam String code) {
        bookService.returnBook(code); // Có thể ném exception nếu code không tồn tại
        return "redirect:/books";
    }
    @GetMapping("/borrowed")
    public String viewBorrowedBooks(Model model) {
        List<BorrowBook> borrowed = bookService.getAllBorrowedBooks();
        model.addAttribute("borrowedList", borrowed);
        return "book/borrowed_list"; // templates/book/borrowed_list.html
    }
}
