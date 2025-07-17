package com.example.store.application.usecase;

import com.example.store.domain.model.Brand;
import com.example.store.domain.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BrandService {
    private final BrandRepository brandRepository;

    public Brand create(Brand brand) {
        return brandRepository.save(brand);
    }

    public Brand getById(UUID id) {
        return brandRepository.findById(id).orElseThrow(() -> new RuntimeException("Brand not found"));
    }

    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    public void delete(UUID id) {
        brandRepository.delete(id);
    }

    public Brand update(UUID id, Brand brand) {
        brandRepository.findById(id).orElseThrow(() -> new RuntimeException("Brand not found"));
        brand.setId(id);
        return brandRepository.save(brand);
    }
} 