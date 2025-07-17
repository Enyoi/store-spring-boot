package com.example.store.shared.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseItemDto {
    private UUID id;
    private UUID purchaseId;
    private UUID productId;
    private Integer quantity;
    private BigDecimal unitCost;
    private BigDecimal subtotal;
} 