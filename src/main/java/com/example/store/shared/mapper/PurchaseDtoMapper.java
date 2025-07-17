package com.example.store.shared.mapper;

import com.example.store.domain.model.Purchase;
import com.example.store.shared.dto.PurchaseDto;
import org.springframework.stereotype.Component;

@Component
public class PurchaseDtoMapper {

    public PurchaseDto toDto(Purchase purchase) {
        if (purchase == null) {
            return null;
        }
        
        return new PurchaseDto(
                purchase.getId(),
                purchase.getSupplierId(),
                purchase.getPurchaseDate(),
                purchase.getStatus(),
                purchase.getTotalAmount(),
                purchase.getInvoiceNumber(),
                null
        );
    }

    public Purchase toDomain(PurchaseDto purchaseDto) {
        if (purchaseDto == null) {
            return null;
        }
        
        return new Purchase(
                purchaseDto.getId(),
                purchaseDto.getSupplierId(),
                purchaseDto.getPurchaseDate(),
                purchaseDto.getStatus(),
                purchaseDto.getTotalAmount(),
                purchaseDto.getInvoiceNumber()
        );
    }
} 