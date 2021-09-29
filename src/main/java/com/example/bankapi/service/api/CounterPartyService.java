package com.example.bankapi.service.api;

import com.example.bankapi.dto.CounterPartyDTO;

import java.util.List;

/**
 * Сервисный слой для работы с контрагентами
 */
public interface CounterPartyService {
    /**
     * Добавление контрагента пользователю
     *
     * @param userId          id пользователя
     * @param counterPartyDTO информация о контрагенте
     */
    void addCounterParty(int userId, CounterPartyDTO counterPartyDTO);

    /**
     * Получение списка всех контрагентов пользователя
     *
     * @param userId id пользователя
     * @return список контрагентов пользователя
     */
    List<CounterPartyDTO> getAllCounterParties(int userId);

    /**
     * Перевод средств контрагенту
     *
     * @param counterPartyID id контрагента
     * @param amount         сумма перевода
     */
    void cashTransfer(int counterPartyID, int amount);
}
