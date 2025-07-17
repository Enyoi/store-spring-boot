package com.example.store.application.usecase;

import com.example.store.domain.model.Purchase;
import com.example.store.domain.repository.PurchaseRepository;
import com.example.store.shared.dto.PurchaseDto;
import com.example.store.shared.mapper.PurchaseDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final PurchaseDtoMapper purchaseDtoMapper;

    public List<PurchaseDto> getAllPurchases() {
        List<Purchase> purchases = purchaseRepository.findAll();
        return purchases.stream()
                .map(purchaseDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    public PurchaseDto getPurchaseById(UUID id) {
        Purchase purchase = purchaseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Purchase not found"));
        return purchaseDtoMapper.toDto(purchase);
    }

    public PurchaseDto createPurchase(PurchaseDto purchaseDto) {
        Purchase purchase = purchaseDtoMapper.toDomain(purchaseDto);
        Purchase savedPurchase = purchaseRepository.save(purchase);
        return purchaseDtoMapper.toDto(savedPurchase);
    }

    public PurchaseDto updatePurchase(UUID id, PurchaseDto purchaseDto) {
        purchaseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Purchase not found"));
        Purchase purchaseToUpdate = purchaseDtoMapper.toDomain(purchaseDto);
        purchaseToUpdate.setId(id);
        Purchase updatedPurchase = purchaseRepository.save(purchaseToUpdate);
        return purchaseDtoMapper.toDto(updatedPurchase);
    }

    public void deletePurchase(UUID id) {
        purchaseRepository.deleteById(id);
    }

    public List<PurchaseDto> getPurchasesBySupplier(UUID supplierId) {
        List<Purchase> purchases = purchaseRepository.findBySupplierId(supplierId);
        return purchases.stream()
                .map(purchaseDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<PurchaseDto> getPurchasesByStatus(String status) {
        List<Purchase> purchases = purchaseRepository.findByStatus(status);
        return purchases.stream()
                .map(purchaseDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<PurchaseDto> getPurchasesByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        List<Purchase> purchases = purchaseRepository.findByPurchaseDateBetween(startDate, endDate);
        return purchases.stream()
                .map(purchaseDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    public PurchaseDto updatePurchaseStatus(UUID id, String status) {
        Purchase purchase = purchaseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Purchase not found"));
        
        purchase.setStatus(status);
        Purchase updatedPurchase = purchaseRepository.save(purchase);
        return purchaseDtoMapper.toDto(updatedPurchase);
    }
} 