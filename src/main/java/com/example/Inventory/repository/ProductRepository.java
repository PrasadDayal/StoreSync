package com.example.Inventory.repository;

import com.example.Inventory.model.Product;
import com.example.Inventory.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // product list for logged-in user
    List<Product> findByUser(User user);

    // dashboard counts (user-specific)
    long countByUserAndQuantityLessThan(User user, int quantity);

    long countByUserAndQuantityGreaterThanEqual(User user, int quantity);

    long countByQuantityLessThan(int threshold);

    long countByQuantityGreaterThanEqual(int threshold);

    void deleteByIdAndUser(Long id, User user);
}