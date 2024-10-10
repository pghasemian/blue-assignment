package com.assignment.customer.mapper;


import com.assignment.customer.dto.CustomerDTO;
import com.assignment.customer.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Mapper interface for converting between Customer and CustomerDTO.
 */

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDTO toDTO(Customer customer);

    Customer toEntity(CustomerDTO customerDTO);
}

