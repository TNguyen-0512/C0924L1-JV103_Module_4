package com.example.blog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", columnDefinition = "VARCHAR(100)", nullable = false)
    private String name;
    @Column(name = "description", columnDefinition = "TEXT", nullable = true)
    private String description;
}
