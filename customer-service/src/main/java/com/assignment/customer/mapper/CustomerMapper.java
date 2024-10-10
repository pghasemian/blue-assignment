package com.assignment.customer.mapper;

import com.assignment.customer.dto.CustomerDTO;
import com.assignment.customer.model.Customer;
import org.mapstruct.Mapper;

/**
 * Mapper interface for converting between Customer and CustomerDTO.
 */
@Mapper(componentModel = "spring")
public interface CustomerMapper {

    /**
     * Converts a Customer entity to a CustomerDTO.
     *
     * @param customer the Customer entity to convert
     * @return the converted CustomerDTO
     */
    CustomerDTO toDTO(Customer customer);

    /**
     * Converts a CustomerDTO to a Customer entity.
     *
     * @param customerDTO the CustomerDTO to convert
     * @return the converted Customer entity
     */
    Customer toEntity(CustomerDTO customerDTO);
}
