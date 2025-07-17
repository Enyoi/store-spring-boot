package com.example.store.application.usecase;

import com.example.store.domain.model.Order;
import com.example.store.domain.repository.OrderRepository;
import com.example.store.shared.dto.OrderDto;
import com.example.store.shared.mapper.OrderDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderDtoMapper orderDtoMapper;

    public List<OrderDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(orderDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    public OrderDto getOrderById(UUID id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return orderDtoMapper.toDto(order);
    }

    public OrderDto createOrder(OrderDto orderDto) {
        Order order = orderDtoMapper.toDomain(orderDto);
        Order savedOrder = orderRepository.save(order);
        return orderDtoMapper.toDto(savedOrder);
    }

    public OrderDto updateOrder(UUID id, OrderDto orderDto) {
        orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        Order orderToUpdate = orderDtoMapper.toDomain(orderDto);
        orderToUpdate.setId(id);
        Order updatedOrder = orderRepository.save(orderToUpdate);
        return orderDtoMapper.toDto(updatedOrder);
    }

    public void deleteOrder(UUID id) {
        orderRepository.deleteById(id);
    }

    public List<OrderDto> getOrdersByCustomer(UUID customerId) {
        List<Order> orders = orderRepository.findByCustomerId(customerId);
        return orders.stream()
                .map(orderDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<OrderDto> getOrdersByStatus(String status) {
        List<Order> orders = orderRepository.findByStatus(status);
        return orders.stream()
                .map(orderDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<OrderDto> getOrdersByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        List<Order> orders = orderRepository.findByOrderDateBetween(startDate, endDate);
        return orders.stream()
                .map(orderDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    public OrderDto updateOrderStatus(UUID id, String status) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        
        order.setStatus(status);
        Order updatedOrder = orderRepository.save(order);
        return orderDtoMapper.toDto(updatedOrder);
    }
} 