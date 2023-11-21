package com.example.appp.repository;

import com.example.appp.entity.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<Discount,Integer> {
}
