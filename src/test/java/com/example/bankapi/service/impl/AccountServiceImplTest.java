package com.example.bankapi.service.impl;

import org.junit.jupiter.api.Test;
import com.example.bankapi.dao.AccountDAO;
import com.example.bankapi.dao.CardDAO;
import com.example.bankapi.dto.AccountDTO;
import com.example.bankapi.dto.CardDTO;
import com.example.bankapi.entity.Account;
import com.example.bankapi.entity.Card;
import com.example.bankapi.mapper.api.AccountMapper;
import com.example.bankapi.mapper.api.CardMapper;
import com.example.bankapi.service.api.AccountService;

import java.util.List;

import static java.util.Collections.emptyList;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class AccountServiceImplTest {

    private AccountDAO accountDAO = mock(AccountDAO.class);
    private AccountMapper accountMapper = mock(AccountMapper.class);
    private CardDAO cardDAO = mock(CardDAO.class);
    private CardMapper cardMapper = mock(CardMapper.class);
    private AccountService accountService = new AccountServiceImpl(accountDAO,cardDAO,cardMapper,accountMapper);


    @Test
    void getAllAccounts() {
        when(accountDAO.getAllAccounts(1)).thenReturn(emptyList());
        List<AccountDTO> test = accountService.getAllAccounts();
        assertEquals(0,test.size());
        verify(accountDAO).getAllAccounts();
    }

    @Test
    void getAccountByID() {
        AccountDTO accountDTO = new AccountDTO(1,"Test",0,emptyList());
        when(accountMapper.toDTO(any())).thenReturn(accountDTO);
        accountService.getAccountByID(1);
        verify(accountDAO).getAccountById(1);
    }

    @Test
    void addAccount() {
        Account account = new Account(1,"12345",0,emptyList());
        AccountDTO accountDTO = new AccountDTO(1,"Test",0,emptyList());
        when(accountMapper.toEntity(any())).thenReturn(account);
        accountService.addAccount(1, accountDTO);
        verify(accountMapper).toEntity(accountDTO);
        verify(accountDAO).addAccount(1,account);
    }

}