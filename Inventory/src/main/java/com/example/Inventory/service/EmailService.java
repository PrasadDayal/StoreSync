package com.example.Inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired(required = false)
    private JavaMailSender mailSender;

    public void sendLowStockAlert(String productName) {

        if (mailSender == null) {
            // Email not configured yet – avoid crash
            System.out.println("Email not sent. JavaMailSender not configured.");
            return;
        }

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("admin@gmail.com");
        message.setSubject("Low Stock Alert");
        message.setText("Product " + productName + " is running low!");

        mailSender.send(message);
    }
}
