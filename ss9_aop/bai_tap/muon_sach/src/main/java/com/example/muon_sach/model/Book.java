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
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title", columnDefinition = "VARCHAR(100)", nullable = false)
    private String title;
    @Column(name = "quantity", columnDefinition = "INT DEFAULT 0", nullable = false)
    private int quantity;
}
