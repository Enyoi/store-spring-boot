package com.example.store.infrastructure.persistence.repository;

import com.example.store.infrastructure.persistence.entity.PurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface JpaPurchaseRepository extends JpaRepository<PurchaseEntity, UUID> {
    List<PurchaseEntity> findBySupplierId(UUID supplierId);
    List<PurchaseEntity> findByStatus(String status);
    List<PurchaseEntity> findByPurchaseDateBetween(LocalDateTime startDate, LocalDateTime endDate);
} 