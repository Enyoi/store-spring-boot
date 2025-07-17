package com.example.store.domain.repository;

import com.example.store.domain.model.Order;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderRepository {
    List<Order> findAll();
    Optional<Order> findById(UUID id);
    Order save(Order order);
    void deleteById(UUID id);
    List<Order> findByCustomerId(UUID customerId);
    List<Order> findByStatus(String status);
    List<Order> findByOrderDateBetween(LocalDateTime startDate, LocalDateTime endDate);
} 