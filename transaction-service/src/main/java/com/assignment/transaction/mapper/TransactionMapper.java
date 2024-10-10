package com.assignment.transaction.mapper;

import com.assignment.transaction.dto.TransactionDTO;
import com.assignment.transaction.model.Transactions;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Mapper interface for converting between Transaction and TransactionDTO.
 */
@Mapper(componentModel = "spring")
public interface TransactionMapper {

    TransactionDTO toDTO(Transactions transaction);

    Transactions toEntity(TransactionDTO transactionDTO);
}

