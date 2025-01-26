package com.mgk.ecom.controller;

import com.mgk.ecom.dto.ErrorDto;
import com.mgk.ecom.exception.ProductNotFoundException;
import com.mgk.ecom.model.Product;
import com.mgk.ecom.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(@Qualifier("ProductService") ProductService productService){
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
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        Product p = productService.getProductById(id);
        ResponseEntity<Product> response = new ResponseEntity<>(
                p, HttpStatus.OK
        );
        return response;
    }

    @PutMapping("/products/{id}")
    public void updateProduct(@PathVariable("id") Long id,@RequestBody Product product) {
        productService.updateProduct(id, product);
    }

    @DeleteMapping("products/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDto> handleProductNotFoundException(Exception e){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(e.getMessage());

        ResponseEntity<ErrorDto> response = new ResponseEntity<>(
                errorDto, HttpStatus.NOT_FOUND
        );
        return response;
    }

}


