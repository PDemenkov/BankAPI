package com.example.bankapi.mapper;

import org.junit.jupiter.api.Test;
import com.example.bankapi.dto.AccountDTO;
import com.example.bankapi.entity.Account;
import com.example.bankapi.mapper.impl.AccountMapperImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountMapperTest {

    private final AccountMapperImpl accountMapper = new AccountMapperImpl();

    @Test
    void toEntity() {
        Account account = accountMapper.toEntity(new AccountDTO(11,"Test",1000, null));
        assertNotNull(account);
        assertEquals(11,account.getId());
        assertEquals("Test", account.getAccountNumber());
        assertEquals(1000, account.getBalance());
        assertNull(account.getCards());
    }

    @Test
    void toDTO() {
        AccountDTO accountDTO = accountMapper.toDTO(new Account(10, "Test", 123123, null));
        assertNotNull(accountDTO);
        assertEquals(10,accountDTO.getId());
        assertEquals("Test", accountDTO.getAccountNumber());
        assertEquals(123123, accountDTO.getBalance());
        assertNull(accountDTO.getCards());
    }

    @Test
    void toEntityList() {
        List<AccountDTO> dtos = new ArrayList<>();
        assertNotNull(dtos);
        dtos.add(new AccountDTO(1,"Test",123,null));
        List<Account> list = accountMapper.toEntityList(dtos);
        assertNotNull(list);
    }

    @Test
    void toDTOList() {
        List<Account> accounts = new ArrayList<>();
        assertNotNull(accounts);
        accounts.add(new Account(1,"Test",123,null));
        List<AccountDTO> list = accountMapper.toDTOList(accounts);
        assertNotNull(list);
    }
}