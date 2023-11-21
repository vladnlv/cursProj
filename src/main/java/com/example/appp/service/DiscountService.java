package com.example.appp.service;

import com.example.appp.repository.DiscountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiscountService {
    private final DiscountRepository discountRepository;

}
