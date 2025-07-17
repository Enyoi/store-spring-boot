package com.example.store.shared.mapper;

import com.example.store.domain.model.Supplier;
import com.example.store.shared.dto.SupplierDto;
import org.springframework.stereotype.Component;

@Component
public class SupplierDtoMapper {

    public SupplierDto toDto(Supplier supplier) {
        if (supplier == null) {
            return null;
        }
        
        return new SupplierDto(
                supplier.getId(),
                supplier.getName(),
                supplier.getEmail(),
                supplier.getPhone(),
                supplier.getAddress(),
                supplier.getContactPerson()
        );
    }

    public Supplier toDomain(SupplierDto supplierDto) {
        if (supplierDto == null) {
            return null;
        }
        
        return new Supplier(
                supplierDto.getId(),
                supplierDto.getName(),
                supplierDto.getEmail(),
                supplierDto.getPhone(),
                supplierDto.getAddress(),
                supplierDto.getContactPerson()
        );
    }
} 