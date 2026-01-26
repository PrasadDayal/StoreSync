package com.example.Inventory.controller;

import com.example.Inventory.model.Product;
import com.example.Inventory.model.User;
import com.example.Inventory.service.ProductService;
import com.example.Inventory.service.UserService;

import java.security.Principal;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final UserService userService;

    public ProductController(ProductService productService,
                             UserService userService) {
        this.productService = productService;
        this.userService = userService;
    }

    // ✅ LIST PRODUCTS (USER-SPECIFIC)
    @GetMapping
    public String products(Model model, Principal principal) {

        User user = userService.findByUsername(principal.getName());
        List<Product> products = productService.findByUser(user);

        model.addAttribute("products", products);
        return "products";
    }

    // ✅ SHOW ADD PRODUCT FORM
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("product", new Product());
        return "add-product";
    }

    // ✅ SAVE PRODUCT (FIXED)
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute Product product,
                              Principal principal) {

        User user = userService.findByUsername(principal.getName());
        product.setUser(user);   // ⭐ CRITICAL LINE

        productService.save(product);
        return "redirect:/dashboard";
    }

    // ✅ DELETE PRODUCT
    @GetMapping("/delete/{id}")
public String deleteProduct(@PathVariable Long id, Principal principal) {

    User user = userService.findByUsername(principal.getName());
    productService.deleteByIdAndUser(id, user);

    return "redirect:/products";
}

}