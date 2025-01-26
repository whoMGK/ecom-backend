package com.mgk.ecom.repository;

import com.mgk.ecom.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    //Create
    Product save(Product product);
    //findById
    Optional<Product> findById(Long id);
}
