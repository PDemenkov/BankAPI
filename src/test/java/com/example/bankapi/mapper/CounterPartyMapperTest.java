package com.example.bankapi.mapper;

import org.junit.jupiter.api.Test;
import com.example.bankapi.dto.CounterPartyDTO;
import com.example.bankapi.entity.CounterParty;
import com.example.bankapi.mapper.impl.CounterPartyMapperImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CounterPartyMapperTest {

    private final CounterPartyMapperImpl counterPartyMapper = new CounterPartyMapperImpl();

    @Test
    void toEntity() {
        CounterParty counterParty = counterPartyMapper.toEntity(new CounterPartyDTO(3,"Test", null));
        assertEquals(3, counterParty.getId());
        assertEquals("Test", counterParty.getName());
        assertNull(counterParty.getAccounts());
    }

    @Test
    void toDTO() {
        CounterPartyDTO counterPartyDTO = counterPartyMapper.toDTO(new CounterParty(3,"Test", null));
        assertEquals(3, counterPartyDTO.getId());
        assertEquals("Test", counterPartyDTO.getName());
        assertNull(counterPartyDTO.getAccounts());
    }

    @Test
    void toEntityList() {
        List<CounterPartyDTO> counterParties = new ArrayList<>();
        counterParties.add(new CounterPartyDTO(1,"Test",null));
        List<CounterParty> list = counterPartyMapper.toEntityList(counterParties);
        assertNotNull(list);
    }

    @Test
    void toDTOList() {
        List<CounterParty> counterParties = new ArrayList<>();
        counterParties.add(new CounterParty(1,"Test",null));
        List<CounterPartyDTO> list = counterPartyMapper.toDTOList(counterParties);
        assertNotNull(list);
    }
}