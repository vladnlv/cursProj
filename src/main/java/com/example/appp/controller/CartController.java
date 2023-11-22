package com.example.appp.controller;

import com.example.appp.dto.CartDto;
import com.example.appp.entity.Cart;
import com.example.appp.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @GetMapping("/{id}")
    public ResponseEntity<Cart> getById(@PathVariable Integer id){
        Optional<Cart> cartOptional = cartService.getById(id);
        if(cartOptional.isPresent()){
            return ResponseEntity.ok(cartOptional.get());
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/user/{userId}")
    public Page<Cart> getAllCartItemsByUserId(
            @PathVariable Integer userId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return cartService.findAllByUserId(userId, pageable);
    }
    @PutMapping("/update")
    public ResponseEntity<Cart> updateCart(@RequestBody Cart updatedCart) {
        return ResponseEntity.ok(cartService.update(updatedCart));
    }

}
