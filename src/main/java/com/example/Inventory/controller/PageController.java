
package com.example.Inventory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Inventory.repository.ProductRepository;

@Controller
public class PageController {

    private final ProductRepository productRepository;

    public PageController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // @GetMapping("/dashboard")
    // public String dashboard(Model model) {
    //     model.addAttribute("totalProducts", productRepository.count());
    //     return "dashboard";
    // }

    // @GetMapping("/products")
    // public String products(Model model) {
    //     model.addAttribute("products", productRepository.findAll());
    //     return "products";
    // }

    @GetMapping("/logout-success")
    public String logoutPage() {
        return "login";
    }
}
