package com.example.bankapi.service.impl;


import org.junit.jupiter.api.Test;
import com.example.bankapi.dao.AccountDAO;
import com.example.bankapi.dao.CardDAO;
import com.example.bankapi.dao.UserDAO;
import com.example.bankapi.dto.CardDTO;
import com.example.bankapi.dto.UserDTO;
import com.example.bankapi.entity.User;
import com.example.bankapi.mapper.api.CardMapper;
import com.example.bankapi.mapper.api.UserMapper;
import com.example.bankapi.service.api.UserService;

import java.util.List;

import static java.util.Collections.emptyList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


class UserServiceImplTest {

    private UserDAO userDAO = mock(UserDAO.class);
    private UserMapper userMapper = mock(UserMapper.class);
    private CardMapper cardMapper = mock(CardMapper.class);
    private AccountDAO accountDAO = mock(AccountDAO.class);
    private CardDAO cardDAO = mock(CardDAO.class);
    private UserService userService = new UserServiceImpl(userDAO,userMapper,cardMapper,accountDAO,cardDAO);

    @Test
    void getAllUsers() {
        when(userDAO.getAllUsers()).thenReturn(emptyList());
        List<UserDTO> test = userService.getAllUsers();
        assertEquals(0,test.size());
        verify(userDAO).getAllUsers();
    }


    @Test
    void getUserById() {
        UserDTO userDTO = new UserDTO(1,"Test","Test", emptyList(),emptyList());
        when(userMapper.toDTO(any())).thenReturn(userDTO);
        userService.getUserById(1);
        verify(userDAO).getUserById(1);
    }

    @Test
    void addUser() {
        User user = new User(1,"Test","Test",emptyList(),emptyList());
        UserDTO userDTO = new UserDTO(1,"Test","Test",emptyList(),emptyList());
        when(userMapper.toEntity(any())).thenReturn(user);
        userService.addUser(userDTO);
        verify(userMapper).toEntity(userDTO);
        verify(userDAO).addUser(user);
    }

    @Test
    void getAllCards() {
        when(accountDAO.getAllAccounts(1)).thenReturn(emptyList());
        cardDAO.getAllCards(1);
        List<CardDTO> test = userService.getAllCards(1);
        assertEquals(0,test.size());
        verify(cardDAO).getAllCards(1);

    }

//    @Test
//    void addCash() {
//        int amount = 500;
//        Account account = new Account(1,"12345",500,emptyList());
//        userService.addCash(1,500);
//        verify(accountDAO).addCash(500,account);
//
//    }

}