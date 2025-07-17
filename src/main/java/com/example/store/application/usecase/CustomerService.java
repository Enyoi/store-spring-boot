package com.example.store.application.usecase;

import com.example.store.domain.model.Customer;
import com.example.store.domain.repository.CustomerRepository;
import com.example.store.shared.dto.CustomerDto;
import com.example.store.shared.mapper.CustomerDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerDtoMapper customerDtoMapper;

    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(customerDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    public CustomerDto getCustomerById(UUID id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        return customerDtoMapper.toDto(customer);
    }

    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = customerDtoMapper.toDomain(customerDto);
        Customer savedCustomer = customerRepository.save(customer);
        return customerDtoMapper.toDto(savedCustomer);
    }

    public CustomerDto updateCustomer(UUID id, CustomerDto customerDto) {
        customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        Customer customerToUpdate = customerDtoMapper.toDomain(customerDto);
        customerToUpdate.setId(id);
        Customer updatedCustomer = customerRepository.save(customerToUpdate);
        return customerDtoMapper.toDto(updatedCustomer);
    }

    public void deleteCustomer(UUID id) {
        customerRepository.deleteById(id);
    }

    public List<CustomerDto> searchCustomersByName(String name) {
        List<Customer> customers = customerRepository.findByNameContaining(name);
        return customers.stream()
                .map(customerDtoMapper::toDto)
                .collect(Collectors.toList());
    }
} 