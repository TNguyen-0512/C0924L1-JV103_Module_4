package com.example.demo.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {

    // Map chứa sản phẩm và số lượng
    private Map<Product, Integer> items = new LinkedHashMap<>();

    // Thêm sản phẩm (nếu đã có thì tăng số lượng)
    public void add(Product product) {
        items.put(product, items.getOrDefault(product, 0) + 1);
    }

    // Cập nhật số lượng sản phẩm theo ID
    public void update(Long productId, int quantity) {
        for (Product p : items.keySet()) {
            if (p.getId().equals(productId)) {
                if (quantity <= 0) {
                    items.remove(p);
                } else {
                    items.put(p, quantity);
                }
                break;
            }
        }
    }

    // Xóa sản phẩm khỏi giỏ hàng
    public void remove(Long productId) {
        items.entrySet().removeIf(entry -> entry.getKey().getId().equals(productId));
    }

    // Tổng tiền giỏ hàng
    public double getTotal() {
        return items.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    // Lấy danh sách sản phẩm và số lượng
    public Map<Product, Integer> getItems() {
        return items;
    }

    // Kiểm tra giỏ hàng rỗng
    public boolean isEmpty() {
        return items.isEmpty();
    }

    // Xóa toàn bộ giỏ hàng
    public void clear() {
        items.clear();
    }
}
