package com.example.store.domain.repository;

import com.example.store.domain.model.Purchase;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PurchaseRepository {
    List<Purchase> findAll();
    Optional<Purchase> findById(UUID id);
    Purchase save(Purchase purchase);
    void deleteById(UUID id);
    List<Purchase> findBySupplierId(UUID supplierId);
    List<Purchase> findByStatus(String status);
    List<Purchase> findByPurchaseDateBetween(LocalDateTime startDate, LocalDateTime endDate);
} 