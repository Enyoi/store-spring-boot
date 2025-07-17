package com.example.store.infrastructure.persistence.repository;

import com.example.store.infrastructure.persistence.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface JpaCustomerRepository extends JpaRepository<CustomerEntity, UUID> {
    List<CustomerEntity> findByNameContaining(String name);
} 