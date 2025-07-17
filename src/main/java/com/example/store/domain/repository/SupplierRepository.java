package com.example.store.domain.repository;

import com.example.store.domain.model.Supplier;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SupplierRepository {
    List<Supplier> findAll();
    Optional<Supplier> findById(UUID id);
    Supplier save(Supplier supplier);
    void deleteById(UUID id);
    List<Supplier> findByNameContaining(String name);
} 