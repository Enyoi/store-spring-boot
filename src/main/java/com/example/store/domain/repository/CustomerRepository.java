package com.example.store.domain.repository;

import com.example.store.domain.model.Customer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {
    List<Customer> findAll();
    Optional<Customer> findById(UUID id);
    Customer save(Customer customer);
    void deleteById(UUID id);
    List<Customer> findByNameContaining(String name);
} 