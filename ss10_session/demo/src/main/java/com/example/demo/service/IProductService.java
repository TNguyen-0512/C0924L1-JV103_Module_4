package com.example.demo.service;

import com.example.demo.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    Product findById(Long id);

    void save(Product product);       // thêm hoặc cập nhật

    void deleteById(Long id);          // xoá sản phẩm
}
