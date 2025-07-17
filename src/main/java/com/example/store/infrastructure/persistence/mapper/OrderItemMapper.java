package com.example.store.infrastructure.persistence.mapper;

import com.example.store.domain.model.OrderItem;
import com.example.store.infrastructure.persistence.entity.OrderItemEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderItemMapper {
    public OrderItem toModel(OrderItemEntity entity) {
        return new OrderItem(
                entity.getId(),
                entity.getOrder().getId(),
                entity.getProduct().getId(),
                entity.getQuantity(),
                entity.getUnitPrice(),
                entity.getSubtotal()
        );
    }

    public OrderItemEntity toEntity(OrderItem model) {
        OrderItemEntity entity = new OrderItemEntity();
        entity.setId(model.getId());
        entity.setQuantity(model.getQuantity());
        entity.setUnitPrice(model.getUnitPrice());
        entity.setSubtotal(model.getSubtotal());
        return entity;
    }
} 