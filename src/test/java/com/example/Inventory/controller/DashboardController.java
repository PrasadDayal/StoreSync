package com.example.Inventory.controller;

import com.example.Inventory.model.Product;
import com.example.Inventory.model.User;
import com.example.Inventory.repository.ProductRepository;
import com.example.Inventory.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class DashboardController {

    private final ProductRepository productRepository;
    private final UserService userService;

    public DashboardController(ProductRepository productRepository,
                               UserService userService) {
        this.productRepository = productRepository;
        this.userService = userService;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, Principal principal) {

        User user = userService.findByUsername(principal.getName());
        List<Product> products = productRepository.findByUser(user);

        long totalProducts = products.size();
        long lowStock = products.stream().filter(p -> p.getQuantity() > 0 && p.getQuantity() < 10).count();
        long outOfStock = products.stream().filter(p -> p.getQuantity() == 0).count();
        long inStock = products.stream().filter(p -> p.getQuantity() >= 10).count();

        model.addAttribute("username", user.getUsername());
        model.addAttribute("currentPage", "dashboard");
        model.addAttribute("products", products);
        model.addAttribute("totalProducts", totalProducts);
        model.addAttribute("lowStockCount", lowStock);
        model.addAttribute("okStockCount", inStock);
        model.addAttribute("outOfStock", outOfStock);

        model.addAttribute("productNames", products.stream().map(Product::getName).toList());
        model.addAttribute("productStock", products.stream().map(Product::getQuantity).toList());

        model.addAttribute("inStock", inStock);
        model.addAttribute("lowStock", lowStock);

        return "dashboard";
    }
}
