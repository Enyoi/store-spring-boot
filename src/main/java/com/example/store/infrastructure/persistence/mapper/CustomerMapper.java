package com.example.store.infrastructure.persistence.mapper;

import com.example.store.domain.model.Customer;
import com.example.store.infrastructure.persistence.entity.CustomerEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public Customer toModel(CustomerEntity entity) {
        return new Customer(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getPhone(),
                entity.getAddress()
        );
    }

    public CustomerEntity toEntity(Customer model) {
        CustomerEntity entity = new CustomerEntity();
        entity.setId(model.getId());
        entity.setName(model.getName());
        entity.setEmail(model.getEmail());
        entity.setPhone(model.getPhone());
        entity.setAddress(model.getAddress());
        return entity;
    }
} 