package com.example.store.shared.mapper;

import com.example.store.domain.model.OrderItem;
import com.example.store.shared.dto.OrderItemDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderItemDtoMapper {

    public OrderItemDto toDto(OrderItem orderItem) {
        if (orderItem == null) {
            return null;
        }
        
        return new OrderItemDto(
                orderItem.getId(),
                orderItem.getOrderId(),
                orderItem.getProductId(),
                orderItem.getQuantity(),
                orderItem.getUnitPrice(),
                orderItem.getSubtotal()
        );
    }

    public OrderItem toDomain(OrderItemDto orderItemDto) {
        if (orderItemDto == null) {
            return null;
        }
        
        return new OrderItem(
                orderItemDto.getId(),
                orderItemDto.getOrderId(),
                orderItemDto.getProductId(),
                orderItemDto.getQuantity(),
                orderItemDto.getUnitPrice(),
                orderItemDto.getSubtotal()
        );
    }

    public List<OrderItemDto> toDtoList(List<OrderItem> orderItems) {
        if (orderItems == null) {
            return null;
        }
        
        return orderItems.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public List<OrderItem> toDomainList(List<OrderItemDto> orderItemDtos) {
        if (orderItemDtos == null) {
            return null;
        }
        
        return orderItemDtos.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }
} 