package com.example.store.infrastructure.persistence.mapper;

import com.example.store.domain.model.Order;
import com.example.store.domain.model.OrderItem;
import com.example.store.infrastructure.persistence.entity.OrderEntity;
import com.example.store.infrastructure.persistence.entity.OrderItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {
    @Autowired
    private OrderItemMapper orderItemMapper;
    
    public Order toModel(OrderEntity entity) {
        List<OrderItem> orderItems = entity.getOrderItems().stream()
                .map(orderItemMapper::toModel)
                .collect(Collectors.toList());
            
        return new Order(
                entity.getId(),
                entity.getCustomer().getId(),
                entity.getOrderDate(),
                entity.getStatus(),
                entity.getTotalAmount(),
                orderItems
        );
    }

    public OrderEntity toEntity(Order model) {
        OrderEntity entity = new OrderEntity();
        entity.setId(model.getId());
        entity.setOrderDate(model.getOrderDate());
        entity.setStatus(model.getStatus());
        entity.setTotalAmount(model.getTotalAmount());
        
        if (model.getOrderItems() != null) {
            List<OrderItemEntity> orderItemEntities = model.getOrderItems().stream()
                .map(orderItemMapper::toEntity)
                .collect(Collectors.toList());
            entity.setOrderItems(orderItemEntities);
        }
        
        return entity;
    }
} 