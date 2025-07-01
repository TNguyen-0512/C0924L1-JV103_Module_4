package com.example.muon_sach.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BookUnavailableException.class)
    public String handleBookUnavailable(Model model, BookUnavailableException ex) {
        model.addAttribute("message", ex.getMessage());
        return "error/book_unavailable";
    }

    @ExceptionHandler(InvalidBorrowCodeException.class)
    public String handleInvalidCode(Model model, InvalidBorrowCodeException ex) {
        model.addAttribute("message", ex.getMessage());
        return "error/invalid_code";
    }
}