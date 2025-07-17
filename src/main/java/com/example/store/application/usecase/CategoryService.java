package com.example.store.application.usecase;

import com.example.store.domain.model.Category;
import com.example.store.domain.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    public Category getById(UUID id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public void delete(UUID id) {
        categoryRepository.delete(id);
    }

    public Category update(UUID id, Category category) {
        categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
        category.setId(id);
        return categoryRepository.save(category);
    }
} 