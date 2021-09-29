package com.example.bankapi.mapper.api;

import com.example.bankapi.dto.AccountDTO;
import com.example.bankapi.entity.Account;

import java.util.List;

/**
 * Класс для маппинга DTO и Entity объектов
 */
public interface AccountMapper {
    /**
     * Маппинг DTO в Entity
     *
     * @param accountDTO объект DTO
     * @return объект Entity
     */
    Account toEntity(AccountDTO accountDTO);

    /**
     * Маппинг Entity в DTO
     *
     * @param account объект Entity
     * @return объект DTO
     */
    AccountDTO toDTO(Account account);

    /**
     * Маппинг списка объектов DTO в список объектов Entity
     *
     * @param accountDTOList список объектов DTO
     * @return список объектов Entity
     */
    List<Account> toEntityList(List<AccountDTO> accountDTOList);

    /**
     * Маппинг списка объектов Entity в список объектов DTO
     *
     * @param accountList список объектов Entity
     * @return список объектов DTO
     */
    List<AccountDTO> toDTOList(List<Account> accountList);
}
