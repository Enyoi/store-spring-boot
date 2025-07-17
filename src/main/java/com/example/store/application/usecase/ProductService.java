package com.example.store.application.usecase;

import com.example.store.domain.model.Product;
import com.example.store.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product create(Product product) {
        return productRepository.save(product);
    }

    public Product getById(UUID id) {
        return productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product not found"));
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void delete(UUID id) {
        productRepository.delete(id);
    }

    public Product update(UUID id, Product product) {
        productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setId(id);
        return productRepository.save(product);
    }
}
