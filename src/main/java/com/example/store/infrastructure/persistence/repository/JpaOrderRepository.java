package com.example.store.infrastructure.persistence.repository;

import com.example.store.infrastructure.persistence.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface JpaOrderRepository extends JpaRepository<OrderEntity, UUID> {
    List<OrderEntity> findByCustomerId(UUID customerId);
    List<OrderEntity> findByStatus(String status);
    List<OrderEntity> findByOrderDateBetween(LocalDateTime startDate, LocalDateTime endDate);
} 