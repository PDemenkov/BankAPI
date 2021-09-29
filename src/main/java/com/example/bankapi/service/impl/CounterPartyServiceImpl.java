package com.example.bankapi.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.bankapi.dao.AccountDAO;
import com.example.bankapi.dao.CounterPartyDAO;
import com.example.bankapi.dto.CounterPartyDTO;
import com.example.bankapi.entity.Account;
import com.example.bankapi.exception.NoSuchCounterPartyException;
import com.example.bankapi.mapper.api.CounterPartyMapper;
import com.example.bankapi.service.api.CounterPartyService;

import java.util.List;

@Service
public class CounterPartyServiceImpl implements CounterPartyService {

    private final CounterPartyDAO counterPartyDAO;

    private final CounterPartyMapper counterPartyMapper;

    private final AccountDAO accountDAO;

    public CounterPartyServiceImpl(CounterPartyDAO counterPartyDAO,
                                   CounterPartyMapper counterPartyMapper, AccountDAO accountDAO) {
        this.counterPartyDAO = counterPartyDAO;
        this.counterPartyMapper = counterPartyMapper;
        this.accountDAO = accountDAO;
    }

    @Transactional
    public void addCounterParty(int userId, CounterPartyDTO counterPartyDTO) {
        counterPartyDAO.add(userId, counterPartyMapper.toEntity(counterPartyDTO));
    }

    public List<CounterPartyDTO> getAllCounterParties(int userId) {
        List<CounterPartyDTO> counterParties = counterPartyMapper.toDTOList(counterPartyDAO.getAllCounterParties(userId));
        if (counterParties == null) {
            throw new NoSuchCounterPartyException();
        }
        return counterParties;
    }

    @Transactional
    public void cashTransfer(int counterPartyID, int amount) {
        List<Account> accounts = accountDAO.getAllCounterPartyAccounts(counterPartyID);
        Account account = accounts.get(0);
        accountDAO.addCash(amount, account);
    }


}
