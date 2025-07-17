package com.example.store.infrastructure.persistence.repository;

import com.example.store.domain.model.Supplier;
import com.example.store.domain.repository.SupplierRepository;
import com.example.store.infrastructure.persistence.mapper.SupplierMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class SupplierRepositoryImpl implements SupplierRepository {
    private final JpaSupplierRepository jpaSupplierRepository;
    private final SupplierMapper mapper;

    @Override
    public List<Supplier> findAll() {
        return jpaSupplierRepository.findAll().stream().map(mapper::toModel).collect(Collectors.toList());
    }

    @Override
    public Optional<Supplier> findById(UUID id) {
        return jpaSupplierRepository.findById(id).map(mapper::toModel);
    }

    @Override
    public Supplier save(Supplier supplier) {
        return mapper.toModel(jpaSupplierRepository.save(mapper.toEntity(supplier)));
    }

    @Override
    public void deleteById(UUID id) {
        jpaSupplierRepository.deleteById(id);
    }

    @Override
    public List<Supplier> findByNameContaining(String name) {
        return jpaSupplierRepository.findByNameContaining(name).stream().map(mapper::toModel).collect(Collectors.toList());
    }
} 