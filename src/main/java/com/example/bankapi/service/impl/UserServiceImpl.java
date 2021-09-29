package com.example.bankapi.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.bankapi.dao.AccountDAO;
import com.example.bankapi.dao.CardDAO;
import com.example.bankapi.dao.UserDAO;
import com.example.bankapi.dto.CardDTO;
import com.example.bankapi.dto.UserDTO;
import com.example.bankapi.entity.Account;
import com.example.bankapi.entity.Card;
import com.example.bankapi.entity.User;
import com.example.bankapi.exception.NoSuchCardException;
import com.example.bankapi.exception.NoSuchUserException;
import com.example.bankapi.mapper.api.CardMapper;
import com.example.bankapi.mapper.api.UserMapper;
import com.example.bankapi.service.api.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    private final UserMapper userMapper;

    private final CardMapper cardMapper;

    private final AccountDAO accountDAO;

    private final CardDAO cardDAO;

    public UserServiceImpl(UserDAO userDAO, UserMapper userMapper, CardMapper cardMapper, AccountDAO accountDAO, CardDAO cardDAO) {
        this.userDAO = userDAO;
        this.userMapper = userMapper;
        this.cardMapper = cardMapper;
        this.accountDAO = accountDAO;
        this.cardDAO = cardDAO;
    }

    public List<UserDTO> getAllUsers() {
        List<User> users = userDAO.getAllUsers();
        List<UserDTO> result = new ArrayList<>();
        for (User u : users) {
            result.add(userMapper.toDTO(u));
        }
        return result;
    }

    public UserDTO getUserById(int id) throws NoSuchUserException {
        UserDTO user = userMapper.toDTO(userDAO.getUserById(id));
        if (user == null) {
            throw new NoSuchUserException();
        }
        return user;
    }

    @Transactional
    public void addUser(UserDTO userDTO) {
        userDAO.addUser(userMapper.toEntity(userDTO));
    }

    public List<CardDTO> getAllCards(int userId) {
        List<Account> userAccounts = accountDAO.getAllAccounts(userId);
        List<CardDTO> userCards = new ArrayList<>();
        for (Account account : userAccounts) {
            List<Card> accountCards = cardDAO.getAllCards(account.getId());
            if (accountCards == null) {
                throw new NoSuchCardException();
            }
            for (Card card : accountCards) {
                userCards.add(cardMapper.toDTO(card));
            }
        }
        return userCards;
    }

    @Transactional
    public void addCash(int accountId, int amount) {
        Account account = accountDAO.getAccountById(accountId);
        accountDAO.addCash(amount, account);
    }

}
