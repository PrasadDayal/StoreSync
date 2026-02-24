package com.example.Inventory.controller;

import com.example.Inventory.model.Product;
import com.example.Inventory.model.User;
import com.example.Inventory.repository.ProductRepository;
import com.example.Inventory.service.ProductService;
import com.example.Inventory.service.UserService;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final UserService userService;
    private final ProductRepository productRepository;

    public ProductController(ProductService productService, UserService userService, ProductRepository productRepository) {
        this.productService = productService;
        this.userService = userService;
        this.productRepository = productRepository;
    }

    @GetMapping
    public String products(Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        List<Product> products = productService.findByUser(user);
        model.addAttribute("username", user.getUsername());
        model.addAttribute("currentPage", "products");
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/add")
    public String addForm(Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("username", user.getUsername());
        model.addAttribute("currentPage", "add-product");
        model.addAttribute("product", new Product());
        return "add-product";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute Product product, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        product.setUser(user);
        productService.save(product);
        return "redirect:/products";
    }

    @GetMapping("/search")
    public String searchProduct(@RequestParam String keyword, Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("username", user.getUsername());
        model.addAttribute("currentPage", "products");
        model.addAttribute("products", productRepository.findByNameContainingAndUser(keyword, user));
        return "products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id, Principal principal, RedirectAttributes redirectAttributes) {
        User user = userService.findByUsername(principal.getName());
        productService.deleteByIdAndUser(id, user);
        redirectAttributes.addFlashAttribute("success", "Product deleted successfully");
        return "redirect:/products";
    }
}
