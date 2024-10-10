package com.assignment.account.mapper;

import com.assignment.account.dto.AccountDTO;
import com.assignment.account.model.Account;
import org.mapstruct.Mapper;

/**
 * Mapper interface for converting between Account and AccountDTO.
 */
@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountDTO toDTO(Account account);

    Account toEntity(AccountDTO accountDTO);
}

