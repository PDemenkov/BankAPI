package com.example.bankapi.service.api;

import com.example.bankapi.dto.AccountDTO;
import com.example.bankapi.dto.CardDTO;

import java.util.List;

/**
 * Сервисный слой для работы со счетами
 */
public interface AccountService {
    /**
     * Получение всех счетов
     *
     * @return список счетов
     */
    List<AccountDTO> getAllAccounts();

    /**
     * Получение информации о счете по id
     *
     * @param id id счета
     * @return информация о счете
     */
    AccountDTO getAccountByID(int id);

    /**
     * Добавление счета пользователя
     *
     * @param userId  id пользователя
     * @param account информация о счете
     */
    void addAccount(int userId, AccountDTO account);

    /**
     * Добавление карты к счету
     *
     * @param accountId id счета
     * @param card      информация о карте
     */
    void addCard(int accountId, CardDTO card);

    /**
     * Получение баланса счета
     *
     * @param accountId id счета
     * @return сумма баланса
     */
    Integer getBalance(int accountId);
}
