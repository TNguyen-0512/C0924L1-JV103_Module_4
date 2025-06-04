package com.example.demo.service;

import com.example.demo.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void add(Product product);
    Product findById(int id);
    void update(Product product);
    void deleteById(int id);
    Product findByName(String name);
}
