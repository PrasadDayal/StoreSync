package com.example.Inventory.service;

import com.example.Inventory.model.User;
import com.example.Inventory.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
public User findByUsername(String username) {
    return userRepository
            .findByUsername(username)
            .orElse(null); // or throw exception
}
}