package com.example.Inventory.service;

import org.springframework.stereotype.Service;
import com.example.Inventory.model.Product;
import com.example.Inventory.util.DemandCalculator;

@Service
public class PredictionService {
    public int predictDemand(Product product) {
        return DemandCalculator.predictNextMonthDemand(product.getQuantity());
    }
}
