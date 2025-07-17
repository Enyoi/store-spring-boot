package com.example.store.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Purchase {
    private UUID id;
    private UUID supplierId;
    private LocalDateTime purchaseDate;
    private String status;
    private BigDecimal totalAmount;
    private String invoiceNumber;
} 