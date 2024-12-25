package com.mgk.ecom.controller;

import com.mgk.ecom.model.Product;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @PostMapping("/products")
    public void createProduct(Product product) {

    }

    @GetMapping("/products")
    public Product getProductById(Long id) {
        return null;
    }

    @PutMapping("/products")
    public void updateProduct(Product product) {

    }

    @DeleteMapping("products")
    public void deleteProduct(Long id) {

    }
}
