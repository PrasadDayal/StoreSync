package com.example.Inventory.service;

import com.example.Inventory.model.User;

public interface UserService {
    User findByUsername(String username);
}