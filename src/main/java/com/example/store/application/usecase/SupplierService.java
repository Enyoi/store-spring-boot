package com.example.store.application.usecase;

import com.example.store.domain.model.Supplier;
import com.example.store.domain.repository.SupplierRepository;
import com.example.store.shared.dto.SupplierDto;
import com.example.store.shared.mapper.SupplierDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SupplierService {

    private final SupplierRepository supplierRepository;
    private final SupplierDtoMapper supplierDtoMapper;

    public List<SupplierDto> getAllSuppliers() {
        List<Supplier> suppliers = supplierRepository.findAll();
        return suppliers.stream()
                .map(supplierDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    public SupplierDto getSupplierById(UUID id) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));
        return supplierDtoMapper.toDto(supplier);
    }

    public SupplierDto createSupplier(SupplierDto supplierDto) {
        Supplier supplier = supplierDtoMapper.toDomain(supplierDto);
        Supplier savedSupplier = supplierRepository.save(supplier);
        return supplierDtoMapper.toDto(savedSupplier);
    }

    public SupplierDto updateSupplier(UUID id, SupplierDto supplierDto) {
        supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));
        Supplier supplierToUpdate = supplierDtoMapper.toDomain(supplierDto);
        supplierToUpdate.setId(id);
        Supplier updatedSupplier = supplierRepository.save(supplierToUpdate);
        return supplierDtoMapper.toDto(updatedSupplier);
    }

    public void deleteSupplier(UUID id) {
        supplierRepository.deleteById(id);
    }

    public List<SupplierDto> searchSuppliersByName(String name) {
        List<Supplier> suppliers = supplierRepository.findByNameContaining(name);
        return suppliers.stream()
                .map(supplierDtoMapper::toDto)
                .collect(Collectors.toList());
    }
} 