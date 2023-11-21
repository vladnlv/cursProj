package com.example.appp.service;

import com.example.appp.dto.ProductDto;
import com.example.appp.entity.Product;
import com.example.appp.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product createProduct(ProductDto productDto) {
        Product product = new Product(null, productDto.getProductName(), productDto.getPrice(), productDto.getCategory(), productDto.getCount());
        return productRepository.save(product);
    }

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProductById(Integer productId) {
        productRepository.deleteById(productId);
    }

    public Page<Product> getAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }
    public Page<Product> findAllByCategory(String catrgory,Pageable pageable){
        return productRepository.findAllByCategory(catrgory,pageable);
    }
    public List<String> findAllCategories(){
        return productRepository.findAllCategories();
    }

}
