package com.example.store.infrastructure.controller;

import com.example.store.application.usecase.PurchaseService;
import com.example.store.shared.dto.PurchaseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/purchases")
@RequiredArgsConstructor
public class PurchaseController {
    private final PurchaseService purchaseService;

    @GetMapping
    public ResponseEntity<List<PurchaseDto>> getAllPurchases() {
        return ResponseEntity.ok(purchaseService.getAllPurchases());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseDto> getPurchaseById(@PathVariable UUID id) {
        return ResponseEntity.ok(purchaseService.getPurchaseById(id));
    }

    @PostMapping
    public ResponseEntity<PurchaseDto> createPurchase(@RequestBody PurchaseDto purchaseDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(purchaseService.createPurchase(purchaseDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PurchaseDto> updatePurchase(@PathVariable UUID id, @RequestBody PurchaseDto purchaseDto) {
        return ResponseEntity.ok(purchaseService.updatePurchase(id, purchaseDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePurchase(@PathVariable UUID id) {
        purchaseService.deletePurchase(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/supplier/{supplierId}")
    public ResponseEntity<List<PurchaseDto>> getPurchasesBySupplier(@PathVariable UUID supplierId) {
        return ResponseEntity.ok(purchaseService.getPurchasesBySupplier(supplierId));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<PurchaseDto>> getPurchasesByStatus(@PathVariable String status) {
        return ResponseEntity.ok(purchaseService.getPurchasesByStatus(status));
    }

    @GetMapping("/date-range")
    public ResponseEntity<List<PurchaseDto>> getPurchasesByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        return ResponseEntity.ok(purchaseService.getPurchasesByDateRange(startDate, endDate));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<PurchaseDto> updatePurchaseStatus(@PathVariable UUID id, @RequestParam String status) {
        return ResponseEntity.ok(purchaseService.updatePurchaseStatus(id, status));
    }
} 