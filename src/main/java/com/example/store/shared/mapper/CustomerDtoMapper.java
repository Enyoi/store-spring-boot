package com.example.store.shared.mapper;

import com.example.store.domain.model.Customer;
import com.example.store.shared.dto.CustomerDto;
import org.springframework.stereotype.Component;

@Component
public class CustomerDtoMapper {

    public CustomerDto toDto(Customer customer) {
        if (customer == null) {
            return null;
        }
        
        return new CustomerDto(
                customer.getId(),
                customer.getName(),
                customer.getEmail(),
                customer.getPhone(),
                customer.getAddress()
        );
    }

    public Customer toDomain(CustomerDto customerDto) {
        if (customerDto == null) {
            return null;
        }
        
        return new Customer(
                customerDto.getId(),
                customerDto.getName(),
                customerDto.getEmail(),
                customerDto.getPhone(),
                customerDto.getAddress()
        );
    }
} 