package com.example.bai_1.repository;

import com.example.bai_1.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    void add(Product product);
    Product findById(int id);
    void update(Product product);
    void deleteById(int id);
}
