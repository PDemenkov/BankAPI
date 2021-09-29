package com.example.bankapi.dao;

import com.example.bankapi.entity.Account;

import java.util.List;

/**
 * DAO - слой для работы со счетами
 */
public interface AccountDAO {
    /**
     * Получение всех счетов пользователя
     *
     * @param userId id пользователя в БД
     * @return список всех счетов пользователя
     */
    List<Account> getAllAccounts(int userId);

    /**
     * Получение всех счетов контрагента
     *
     * @param counterPartiId id контрагента в БД
     * @return список всех счетов контрагента
     */
    List<Account> getAllCounterPartyAccounts(int counterPartiId);

    /**
     * Получение всех счетов из базы, без привязки к конкретному пользователю
     *
     * @return список всех счетов содержащихся в БД
     */
    List<Account> getAllAccounts();

    /**
     * Получение счета по id
     *
     * @param id id счета в БД
     * @return информация о счете
     */
    Account getAccountById(int id);

    /**
     * Создание нового счета у пользователя
     *
     * @param userId  id пользователя в БД
     * @param account данные нового счета
     */
    void addAccount(int userId, Account account);

    /**
     * Пополнение счета
     *
     * @param amount  сумма пополнения
     * @param account данные о пополняемом счете
     */
    void addCash(int amount, Account account);

    /**
     * Получение баланса счета
     *
     * @param accountId id счета в БД
     * @return сумма баланса
     */
    Integer getBalance(int accountId);


}
