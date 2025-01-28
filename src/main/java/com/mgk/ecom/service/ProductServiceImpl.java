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
         return productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException("Product not found"));
    }

    @Override
    public List<Product> getProducts() throws ProductNotFoundException {
        List<Product> products = productRepository.findAll();
        if(products.isEmpty()){
            throw new ProductNotFoundException("No products found");
        }
        return products;
    }

    @Override
    public Product createProduct(Product product) {
        String title = product.getCategory().getTitle();
        product.setCategory(findOrCreateCategory(title));
        return productRepository.save(product);
    }

    @Override
    public void updateProduct(Long id, Product product) {

    }

    @Override
    public void deleteProduct(Long id) {

    }

    private Category findOrCreateCategory(String title) {
        return categoryRepository.findByTitle(title).orElseGet(()->{
           Category newCategory = new Category();
           newCategory.setTitle(title);
           return categoryRepository.save(newCategory);
        });
    }
}
