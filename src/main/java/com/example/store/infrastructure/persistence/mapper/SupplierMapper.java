package com.example.store.infrastructure.persistence.mapper;

import com.example.store.domain.model.Supplier;
import com.example.store.infrastructure.persistence.entity.SupplierEntity;
import org.springframework.stereotype.Component;

@Component
public class SupplierMapper {
    public Supplier toModel(SupplierEntity entity) {
        return new Supplier(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getPhone(),
                entity.getAddress(),
                entity.getContactPerson()
        );
    }

    public SupplierEntity toEntity(Supplier model) {
        SupplierEntity entity = new SupplierEntity();
        entity.setId(model.getId());
        entity.setName(model.getName());
        entity.setEmail(model.getEmail());
        entity.setPhone(model.getPhone());
        entity.setAddress(model.getAddress());
        entity.setContactPerson(model.getContactPerson());
        return entity;
    }
} 