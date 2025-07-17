package com.example.store.infrastructure.persistence.mapper;

import com.example.store.domain.model.Category;
import com.example.store.infrastructure.persistence.entity.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public Category toModel(CategoryEntity entity) {
        return new Category(entity.getId(), entity.getName());
    }

    public CategoryEntity toEntity(Category model) {
        CategoryEntity entity = new CategoryEntity();
        entity.setId(model.getId());
        entity.setName(model.getName());
        return entity;
    }
}