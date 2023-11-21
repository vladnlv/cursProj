package com.example.appp.repository;

import com.example.appp.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    Page<Product> findAllByCategory(String category, Pageable pageable);

    @Query("SELECT DISTINCT p.category FROM Product p")
    List<String> findAllCategories();
}
