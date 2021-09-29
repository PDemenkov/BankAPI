package com.example.bankapi.mapper.impl;

import org.springframework.stereotype.Component;
import com.example.bankapi.dto.AccountDTO;
import com.example.bankapi.entity.Account;
import com.example.bankapi.mapper.api.AccountMapper;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountMapperImpl implements AccountMapper {

    public Account toEntity(AccountDTO accountDTO) {
        if (accountDTO == null) {
            return null;
        }
        Account account = new Account();
        account.setId(accountDTO.getId());
        account.setAccountNumber(accountDTO.getAccountNumber());
        account.setBalance(accountDTO.getBalance());
        account.setCards(new CardMapperImpl().toEntityList(accountDTO.getCards()));
        return account;
    }

    public AccountDTO toDTO(Account account) {
        if (account == null) {
            return null;
        }
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(account.getId());
        accountDTO.setAccountNumber(account.getAccountNumber());
        accountDTO.setBalance(account.getBalance());
        accountDTO.setCards(new CardMapperImpl().toDTOList(account.getCards()));
        return accountDTO;
    }

    public List<Account> toEntityList(List<AccountDTO> accountDTOList) {
        if (accountDTOList == null) {
            return null;
        }
        List<Account> list = new ArrayList<>();
        for (AccountDTO dto : accountDTOList) {
            list.add(toEntity(dto));
        }
        return list;
    }

    public List<AccountDTO> toDTOList(List<Account> accountList) {
        if (accountList == null) {
            return null;
        }
        List<AccountDTO> list = new ArrayList<>();
        for (Account acc : accountList) {
            list.add(toDTO(acc));
        }
        return list;
    }
}
