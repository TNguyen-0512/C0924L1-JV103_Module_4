package com.example.bai_hat.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "songs")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", columnDefinition = "VARCHAR(800)", nullable = false)
    private String name;
    @Column(name = "artist", columnDefinition = "VARCHAR(300)", nullable = false)
    private String artist;
    @Column(name = "genre", columnDefinition = "VARCHAR(1000)", nullable = false)
    private String genre;
}
