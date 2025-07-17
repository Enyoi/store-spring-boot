package com.example.store.shared.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseDto {
    private UUID id;
    private UUID supplierId;
    private LocalDateTime purchaseDate;
    private String status;
    private BigDecimal totalAmount;
    private String invoiceNumber;
    private List<PurchaseItemDto> purchaseItems;
} 