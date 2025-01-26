package com.mgk.ecom.service;

import com.mgk.ecom.exception.ProductNotFoundException;
import com.mgk.ecom.model.Category;
import com.mgk.ecom.model.Product;
import com.mgk.ecom.repository.CategoryRepository;
import com.mgk.ecom.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("ProductService")
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getProductById(long id) throws ProductNotFoundException {
        return null;
    }

    @Override
    public List<Product> getProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(Product product) {
        String title = product.getCategory().getTitle();
        Optional<Category> currentCategory = categoryRepository.findByTitle(title);
        if(currentCategory.isEmpty()){
            Category newCategory = new Category();
            newCategory.setTitle(title);
            categoryRepository.save(newCategory);
            product.setCategory(newCategory);
        } else{
            Category existingCategory = currentCategory.get();
            product.setCategory(existingCategory);
        }
        return productRepository.save(product);
    }

    @Override
    public void updateProduct(Long id, Product product) {

    }

    @Override
    public void deleteProduct(Long id) {

    }
}
