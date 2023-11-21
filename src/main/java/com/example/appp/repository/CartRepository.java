package com.example.appp.repository;

import com.example.appp.entity.Cart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Integer> {
    Page<Cart> findAllByUserUserID(Integer userId, Pageable pageable);
}
