package com.example.store.infrastructure.persistence.mapper;

import com.example.store.domain.model.Purchase;
import com.example.store.infrastructure.persistence.entity.PurchaseEntity;
import org.springframework.stereotype.Component;

@Component
public class PurchaseMapper {
    public Purchase toModel(PurchaseEntity entity) {
        return new Purchase(
                entity.getId(),
                entity.getSupplier().getId(),
                entity.getPurchaseDate(),
                entity.getStatus(),
                entity.getTotalAmount(),
                entity.getInvoiceNumber()
        );
    }

    public PurchaseEntity toEntity(Purchase model) {
        PurchaseEntity entity = new PurchaseEntity();
        entity.setId(model.getId());
        entity.setPurchaseDate(model.getPurchaseDate());
        entity.setStatus(model.getStatus());
        entity.setTotalAmount(model.getTotalAmount());
        entity.setInvoiceNumber(model.getInvoiceNumber());
        return entity;
    }
} 