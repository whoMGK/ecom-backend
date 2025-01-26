package com.mgk.ecom.repository;

import com.mgk.ecom.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    //create
    Category save(Category category);

    //Findbytitle
    Optional<Category> findByTitle(String title);

}
