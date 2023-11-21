package com.example.appp.controller;

import com.example.appp.dto.CartDto;
import com.example.appp.entity.Cart;
import com.example.appp.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<Cart> addToCart(CartDto cartDto){
        return ResponseEntity.ok(cartService.create(cartDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id){
        cartService.deleteById(id);
    return ResponseEntity.ok().build();
    }

}
