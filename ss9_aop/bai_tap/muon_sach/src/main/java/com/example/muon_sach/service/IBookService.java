package com.example.muon_sach.service;

import com.example.muon_sach.model.Book;
import com.example.muon_sach.model.BorrowBook;


import java.util.List;

public interface IBookService {
    List<Book> findAll();
    Book findById(Integer id);
    String borrowBook(int id);
    void returnBook(String code);
    List<BorrowBook> getAllBorrowedBooks();
}
