package com.example.muon_sach.repository;

import com.example.muon_sach.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Integer> {
}
