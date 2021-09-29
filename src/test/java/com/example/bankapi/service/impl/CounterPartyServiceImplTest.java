package com.example.bankapi.service.impl;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.example.bankapi.dao.AccountDAO;
import com.example.bankapi.dao.CounterPartyDAO;
import com.example.bankapi.dto.CounterPartyDTO;
import com.example.bankapi.entity.CounterParty;
import com.example.bankapi.mapper.api.CounterPartyMapper;
import com.example.bankapi.service.api.CounterPartyService;

import java.util.List;

import static java.util.Collections.emptyList;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


class CounterPartyServiceImplTest {

    private CounterPartyDAO counterPartyDAO = mock(CounterPartyDAO.class);
    private CounterPartyMapper counterPartyMapper = mock(CounterPartyMapper.class);
    private AccountDAO accountDAO = mock(AccountDAO.class);
    private CounterPartyService counterPartyService = new CounterPartyServiceImpl(
            counterPartyDAO, counterPartyMapper, accountDAO
    );

    @Test
   void addCounterParty() {
        CounterParty counterParty = new CounterParty(1, "Test", emptyList());
        CounterPartyDTO counterPartyDTO = new CounterPartyDTO(1, "Test", emptyList());
        when(counterPartyMapper.toEntity(any())).thenReturn(counterParty);
        counterPartyService.addCounterParty(1, counterPartyDTO);
        verify(counterPartyMapper).toEntity(counterPartyDTO);
        verify(counterPartyDAO).add(1, counterParty);
    }

    @Test
    void getAllCounterParties() {
        when(counterPartyDAO.getAllCounterParties(1)).thenReturn(emptyList());
        List<CounterPartyDTO> test = counterPartyService.getAllCounterParties(1);
        assertEquals(0,test.size());
        verify(counterPartyDAO, Mockito.times(1)).getAllCounterParties(1);
    }

    @Test
    void cashTransfer() {

    }
}