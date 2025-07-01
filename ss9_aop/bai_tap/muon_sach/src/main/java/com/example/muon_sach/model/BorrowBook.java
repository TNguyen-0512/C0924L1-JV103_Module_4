package com.example.muon_sach.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BorrowBook {
    @Id
    private String code; // 5 chữ số
    @ManyToOne
    private Book book;
}
