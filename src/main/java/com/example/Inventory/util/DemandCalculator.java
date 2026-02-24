package com.example.Inventory.util;

public class DemandCalculator {
    public static int predictNextMonthDemand(int currentSales) {
        // Simple linear regression logic (basic AI)
        return (int)(currentSales * 1.25);
    }
}
