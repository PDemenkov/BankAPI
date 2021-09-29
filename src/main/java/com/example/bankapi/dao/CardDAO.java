package com.example.bankapi.dao;

import com.example.bankapi.entity.Card;

import java.util.List;

/**
 * DAO - слой для работы с картами
 */
public interface CardDAO {
    /**
     * Получение списка карт привязанных к счету
     *
     * @param accountId id счета в БД
     * @return список карт этого счета
     */
    List<Card> getAllCards(int accountId);

    /**
     * Добавление новой карты к счету
     *
     * @param accountId id счета в БД
     * @param card      данные карты
     */
    void addCard(int accountId, Card card);
}
