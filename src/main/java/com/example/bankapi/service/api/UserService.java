package com.example.bankapi.service.api;

import com.example.bankapi.dto.CardDTO;
import com.example.bankapi.dto.UserDTO;
import com.example.bankapi.exception.NoSuchUserException;

import java.util.List;

/**
 * Сервисный слой для работы с пользователем
 */
public interface UserService {
    /**
     * Получение списка всех пользователей
     *
     * @return список всех пользователей
     */
    List<UserDTO> getAllUsers();

    /**
     * Получение информации о пользователе по id
     *
     * @param id id пользователя
     * @return информация о пользователе
     */
    UserDTO getUserById(int id) throws NoSuchUserException;

    /**
     * Добавление нового пользователя
     *
     * @param userDTO информация о пользователе
     */
    void addUser(UserDTO userDTO);

    /**
     * Получение списка всех кард пользователя
     *
     * @param userId id пользователя
     * @return список всех карт пользователя
     */
    List<CardDTO> getAllCards(int userId);

    /**
     * Внесение средств на счет пользователя
     *
     * @param accountId id счета пользователя
     * @param amount    сумма для пополнения
     */
    void addCash(int accountId, int amount);
}
