package com.example.appp.controller;

import com.example.appp.dto.ProductDto;
import com.example.appp.entity.Product;
import com.example.appp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductDto productDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(productDto));
    }
    @PutMapping
    public ResponseEntity<Product> update(@RequestBody Product product){
        return ResponseEntity.ok(productService.updateProduct(product));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id){
        productService.deleteProductById(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/{pageNumber}")
    public ResponseEntity<List<Product>> getAll(@PathVariable Integer pageNumber, @RequestParam(defaultValue = "10",name = "pageSize") Integer pageSize){
        return ResponseEntity.ok(productService.getAll(PageRequest.of(pageNumber,pageSize)).getContent());
    }
    @GetMapping("/findById?{id}")
    public ResponseEntity<Product> findById(@PathVariable Integer id){
        Optional<Product> productOptional = productService.findById(id);
        if(productOptional.isPresent()){
            return ResponseEntity.ok(productOptional.get());
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/categories")
    public ResponseEntity<List<String>> findAllCategories(){
        return ResponseEntity.ok(productService.findAllCategories());
    }
    @GetMapping("/products")
    public Page<Product> getAllProductsByCategory(
            @RequestParam String category,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return productService.findAllByCategory(category, pageable);
    }
}
