package com.example.muon_sach.service;


import com.example.muon_sach.exception.BookUnavailableException;
import com.example.muon_sach.exception.InvalidBorrowCodeException;
import com.example.muon_sach.model.Book;
import com.example.muon_sach.model.BorrowBook;
import com.example.muon_sach.repository.IBookRepository;
import com.example.muon_sach.repository.IBorrowBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class BookService implements IBookService  {

    @Autowired
    private IBookRepository bookRepository;
    @Autowired
    private IBorrowBook borrowBook;
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Integer id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public String borrowBook(int id) {
        Book book = findById(id);
        if (book.getQuantity() <= 0) {
            throw new BookUnavailableException("Sách đã hết");
        }
        book.setQuantity(book.getQuantity() - 1);
        bookRepository.save(book);

        String code = String.format("%05d", new Random().nextInt(100000));
        borrowBook.save(new BorrowBook(code, book));
        return code;
    }

    @Override
    public void returnBook(String code) {
        BorrowBook borrow = borrowBook.findById(code)
                .orElseThrow(() -> new InvalidBorrowCodeException("Sai mã mượn sách"));
        Book book = borrow.getBook();
        book.setQuantity(book.getQuantity() + 1);
        bookRepository.save(book);
        borrowBook.delete(borrow);
    }

    @Override
    public List<BorrowBook> getAllBorrowedBooks() {
        return borrowBook.findAll();
    }
}
