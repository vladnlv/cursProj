package com.example.appp.service;

import com.example.appp.dto.CartDto;
import com.example.appp.entity.Cart;
import com.example.appp.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;

    public Cart update(Cart cart){
       return cartRepository.save(cart);
    }
    public Cart create(CartDto cartDto){
        return cartRepository.save(new Cart(null,cartDto.getUser(),cartDto.getProduct(),cartDto.getQuantity()));
    }
    public void deleteById(Integer id){
        cartRepository.deleteById(id);
    }
    public Optional<Cart> getById(Integer id){
        return cartRepository.findById(id);
    }
    public Page<Cart> findAllByUserId(Integer id, Pageable pageable){
        return cartRepository.findAllByUserUserID(id,pageable);
    }
}
