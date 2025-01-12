package com.mgk.ecom.controller;

import com.mgk.ecom.model.Product;
import com.mgk.ecom.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        Product p = productService.createProduct(product);
        return p;
    }

    @GetMapping("/products")
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        Product p = productService.getProductById(id);
        return p;
    }

    @PutMapping("/products/{id}")
    public void updateProduct(@PathVariable("id") Long id,@RequestBody Product product) {
        productService.updateProduct(id, product);
    }

    @DeleteMapping("products/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
    }
}
