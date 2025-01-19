package com.mgk.ecom.service;

import com.mgk.ecom.exception.ProductNotFoundException;
import com.mgk.ecom.model.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(long id) throws ProductNotFoundException;
    List<Product> getProducts();
    Product createProduct(Product product);
    void updateProduct(Long id, Product product);
    void deleteProduct(Long id);
}
