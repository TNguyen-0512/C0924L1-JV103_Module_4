package com.example.bai_1.repository;

import com.example.bai_1.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "TV", 45000, "Tv", "Panasonic"));
        products.add(new Product(2, "Tủ lạnh", 45000, "Fridge", "Panasonic"));
        products.add(new Product(3, "Máy giặt", 45000, "Washing Machine", "Panasonic"));
        products.add(new Product(4, "Điều hòa", 45000, "Air Conditioner", "Panasonic"));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void update(Product updatedProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == updatedProduct.getId()) {
                products.set(i, updatedProduct);
                return;
            }
        }
    }

    @Override
    public void deleteById(int id) {
        products.removeIf(product -> product.getId() == id);
    }
}
