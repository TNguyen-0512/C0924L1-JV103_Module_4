package com.example.blog.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title", columnDefinition = "VARCHAR(100)", nullable = false)
    private String title;
    @Column(name = "content", columnDefinition = "TEXT", nullable = false)
    private String content;
    @Column(name = "author", columnDefinition = "VARCHAR(100)", nullable = false)
    private String author;
    @Column(name ="date_created", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "category", nullable = false)
    private Category category;
}
