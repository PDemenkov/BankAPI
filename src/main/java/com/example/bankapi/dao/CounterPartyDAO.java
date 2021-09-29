package com.example.bankapi.dao;

import com.example.bankapi.entity.CounterParty;

import java.util.List;

/**
 * DAO - слой для работы с контрагентами
 */
public interface CounterPartyDAO {
    /**
     * Получение списка всех контрагентов пользователя
     *
     * @param userId id пользователя в БД
     * @return список контрагентов пользователя
     */
    List<CounterParty> getAllCounterParties(int userId);

    /**
     * Добавление нового контрагента пользователю
     *
     * @param userId       id пользователя в БД
     * @param counterParty данные о контрагенте
     */
    void add(int userId, CounterParty counterParty);

}
