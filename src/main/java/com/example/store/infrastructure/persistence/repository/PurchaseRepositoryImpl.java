package com.example.store.infrastructure.persistence.repository;

import com.example.store.domain.model.Purchase;
import com.example.store.domain.repository.PurchaseRepository;
import com.example.store.infrastructure.persistence.mapper.PurchaseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class PurchaseRepositoryImpl implements PurchaseRepository {
    private final JpaPurchaseRepository jpaPurchaseRepository;
    private final PurchaseMapper mapper;

    @Override
    public List<Purchase> findAll() {
        return jpaPurchaseRepository.findAll().stream().map(mapper::toModel).collect(Collectors.toList());
    }

    @Override
    public Optional<Purchase> findById(UUID id) {
        return jpaPurchaseRepository.findById(id).map(mapper::toModel);
    }

    @Override
    public Purchase save(Purchase purchase) {
        return mapper.toModel(jpaPurchaseRepository.save(mapper.toEntity(purchase)));
    }

    @Override
    public void deleteById(UUID id) {
        jpaPurchaseRepository.deleteById(id);
    }

    @Override
    public List<Purchase> findBySupplierId(UUID supplierId) {
        return jpaPurchaseRepository.findBySupplierId(supplierId).stream().map(mapper::toModel).collect(Collectors.toList());
    }

    @Override
    public List<Purchase> findByStatus(String status) {
        return jpaPurchaseRepository.findByStatus(status).stream().map(mapper::toModel).collect(Collectors.toList());
    }

    @Override
    public List<Purchase> findByPurchaseDateBetween(LocalDateTime startDate, LocalDateTime endDate) {
        return jpaPurchaseRepository.findByPurchaseDateBetween(startDate, endDate).stream().map(mapper::toModel).collect(Collectors.toList());
    }
} 