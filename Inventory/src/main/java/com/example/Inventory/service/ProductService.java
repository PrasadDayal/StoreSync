package com.example.Inventory.service;

import com.example.Inventory.model.Product;
import com.example.Inventory.model.User;
import com.example.Inventory.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {


private final ProductRepository productRepository;


public ProductService(ProductRepository productRepository) {
this.productRepository = productRepository;
}


public void save(Product product) {
productRepository.save(product);
}


public List<Product> getAll() {
return productRepository.findAll();
}


public void deleteById(Long id) {
productRepository.deleteById(id);
}


// ✅ ADD THIS METHOD
public List<Product> findByUser(User user) {
return productRepository.findByUser(user);
}


// dashboard counts
public long lowStockCount(User user, int threshold) {
return productRepository.countByUserAndQuantityLessThan(user, threshold);
}


public long okStockCount(User user, int threshold) {
return productRepository.countByUserAndQuantityGreaterThanEqual(user, threshold);
}


public void deleteByIdAndUser(Long id, User user) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteByIdAndUser'");
}
}