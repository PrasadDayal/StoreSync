package com.example.Inventory.service;

import org.springframework.stereotype.Service;
import com.example.Inventory.model.Product;

public class OrderService {

    public void autoReorder(Product product) {
        if (product.isLowStock()) {
            System.out.println("📦 Auto reorder placed for " + product.getName());
        }
    }
}
