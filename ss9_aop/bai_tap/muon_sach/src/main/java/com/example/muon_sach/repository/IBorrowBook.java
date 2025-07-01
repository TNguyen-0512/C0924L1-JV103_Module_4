package com.example.muon_sach.repository;

import com.example.muon_sach.model.BorrowBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowBook extends JpaRepository<BorrowBook, String> {
}
