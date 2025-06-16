package com.example.bai_1.model;

import javax.persistence.*;

@Entity
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

    public Product() {
    }
    public Product(Integer id, String name, double price, String description, String manufacturer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.manufacturer = manufacturer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}

