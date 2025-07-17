package com.example.store.infrastructure.persistence.repository;

import com.example.store.domain.model.Order;
import com.example.store.domain.repository.OrderRepository;
import com.example.store.infrastructure.persistence.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {
    private final JpaOrderRepository jpaOrderRepository;
    private final OrderMapper mapper;

    @Override
    public List<Order> findAll() {
        return jpaOrderRepository.findAll().stream().map(mapper::toModel).collect(Collectors.toList());
    }

    @Override
    public Optional<Order> findById(UUID id) {
        return jpaOrderRepository.findById(id).map(mapper::toModel);
    }

    @Override
    public Order save(Order order) {
        return mapper.toModel(jpaOrderRepository.save(mapper.toEntity(order)));
    }

    @Override
    public void deleteById(UUID id) {
        jpaOrderRepository.deleteById(id);
    }

    @Override
    public List<Order> findByCustomerId(UUID customerId) {
        return jpaOrderRepository.findByCustomerId(customerId).stream().map(mapper::toModel).collect(Collectors.toList());
    }

    @Override
    public List<Order> findByStatus(String status) {
        return jpaOrderRepository.findByStatus(status).stream().map(mapper::toModel).collect(Collectors.toList());
    }

    @Override
    public List<Order> findByOrderDateBetween(LocalDateTime startDate, LocalDateTime endDate) {
        return jpaOrderRepository.findByOrderDateBetween(startDate, endDate).stream().map(mapper::toModel).collect(Collectors.toList());
    }
} 