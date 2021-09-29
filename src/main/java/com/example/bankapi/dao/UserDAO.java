package com.example.bankapi.dao;

import com.example.bankapi.entity.User;

import java.util.List;

/**
 * DAO - слой для работы с пользователями
 */
public interface UserDAO {
    /**
     * Получение списка всех пользователей из БД
     *
     * @return список всех пользователей содержащихся в БД
     */
    List<User> getAllUsers();

    /**
     * Получение данных о пользователе по id в БД
     *
     * @param id id пользователя в БД
     * @return информация о пользователе
     */
    User getUserById(int id);

    /**
     * Добавление нового пользователя
     *
     * @param user информация о пользователе
     */
    void addUser(User user);


}
