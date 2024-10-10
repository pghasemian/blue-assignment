package com.assignment.account.mapper;

import com.assignment.account.dto.AccountDTO;
import com.assignment.account.model.Account;
import org.mapstruct.Mapper;

/**
 * Mapper interface for converting between Account and AccountDTO.
 */
@Mapper(componentModel = "spring")
public interface AccountMapper {

    /**
     * Converts an Account entity to an AccountDTO.
     *
     * @param account the Account entity to convert
     * @return the converted AccountDTO
     */
    AccountDTO toDTO(Account account);

    /**
     * Converts an AccountDTO to an Account entity.
     *
     * @param accountDTO the AccountDTO to convert
     * @return the converted Account entity
     */
    Account toEntity(AccountDTO accountDTO);
}
