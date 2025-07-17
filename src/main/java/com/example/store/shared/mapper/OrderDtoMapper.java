package com.example.store.shared.mapper;

import com.example.store.domain.model.Order;
import com.example.store.domain.model.OrderItem;
import com.example.store.shared.dto.OrderDto;
import com.example.store.shared.dto.OrderItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderDtoMapper {

    @Autowired
    private OrderItemDtoMapper orderItemDtoMapper;

    public OrderDto toDto(Order order) {
        if (order == null) {
            return null;
        }
        
        List<OrderItemDto> orderItemDtos = null;
        if (order.getOrderItems() != null) {
            orderItemDtos = orderItemDtoMapper.toDtoList(order.getOrderItems());
        } else {
            orderItemDtos = new ArrayList<>();
        }
        
        return new OrderDto(
                order.getId(),
                order.getCustomerId(),
                order.getOrderDate(),
                order.getStatus(),
                order.getTotalAmount(),
                orderItemDtos
        );
    }

    public Order toDomain(OrderDto orderDto) {
        if (orderDto == null) {
            return null;
        }
        
        List<OrderItem> orderItems = null;
        if (orderDto.getOrderItems() != null) {
            orderItems = orderItemDtoMapper.toDomainList(orderDto.getOrderItems());
        } else {
            orderItems = new ArrayList<>();
        }
        
        return new Order(
                orderDto.getId(),
                orderDto.getCustomerId(),
                orderDto.getOrderDate(),
                orderDto.getStatus(),
                orderDto.getTotalAmount(),
                orderItems
        );
    }
} 