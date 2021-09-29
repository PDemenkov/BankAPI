package com.example.bankapi.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.bankapi.dao.AccountDAO;
import com.example.bankapi.dao.CardDAO;
import com.example.bankapi.dto.AccountDTO;
import com.example.bankapi.dto.CardDTO;
import com.example.bankapi.exception.NoSuchAccountException;
import com.example.bankapi.mapper.api.AccountMapper;
import com.example.bankapi.mapper.api.CardMapper;
import com.example.bankapi.service.api.AccountService;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountDAO accountDAO;

    private final CardDAO cardDAO;

    private final CardMapper cardMapper;

    private final AccountMapper accountMapper;

    public AccountServiceImpl(AccountDAO accountDAO, CardDAO cardDAO, CardMapper cardMapper, AccountMapper accountMapper) {
        this.accountDAO = accountDAO;
        this.cardDAO = cardDAO;
        this.cardMapper = cardMapper;
        this.accountMapper = accountMapper;
    }

    public List<AccountDTO> getAllAccounts() {
        List<AccountDTO> accounts = accountMapper.toDTOList(accountDAO.getAllAccounts());
        if (accounts == null) {
            throw new NoSuchAccountException();
        }
        return accounts;
    }

    public AccountDTO getAccountByID(int id) {
        AccountDTO account = accountMapper.toDTO(accountDAO.getAccountById(id));
        if (account == null) {
            throw new NoSuchAccountException();
        }
        return account;
    }

    @Transactional
    public void addAccount(int userId, AccountDTO account) {
        accountDAO.addAccount(userId, accountMapper.toEntity(account));
    }

    @Transactional
    public void addCard(int accountId, CardDTO card) {
        cardDAO.addCard(accountId, cardMapper.toEntity(card));
    }

    public Integer getBalance(int accountId) {
        return accountDAO.getBalance(accountId);
    }
}
