package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name ="name", columnDefinition = "VARCHAR(100)", nullable = false)
    private String name;
    @Column(name="price", columnDefinition = "double", nullable = false)
    private double price;
    @Column(name ="description", columnDefinition = "VARCHAR(100)", nullable = false)
    private String description;
    @Column(name ="manufacturer", columnDefinition = "VARCHAR(100)", nullable = false)
    private String manufacturer;

}

