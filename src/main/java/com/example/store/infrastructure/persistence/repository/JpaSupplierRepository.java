package com.example.store.infrastructure.persistence.repository;

import com.example.store.infrastructure.persistence.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface JpaSupplierRepository extends JpaRepository<SupplierEntity, UUID> {
    List<SupplierEntity> findByNameContaining(String name);
} 