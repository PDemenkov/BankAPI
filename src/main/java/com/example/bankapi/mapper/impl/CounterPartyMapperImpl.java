package com.example.bankapi.mapper.impl;

import org.springframework.stereotype.Component;
import com.example.bankapi.dto.CounterPartyDTO;
import com.example.bankapi.entity.CounterParty;
import com.example.bankapi.mapper.api.CounterPartyMapper;

import java.util.ArrayList;
import java.util.List;

@Component
public class CounterPartyMapperImpl implements CounterPartyMapper {

    public CounterParty toEntity(CounterPartyDTO counterPartyDTO) {
        if (counterPartyDTO == null) {
            return null;
        }
        CounterParty counterParty = new CounterParty();
        counterParty.setId(counterPartyDTO.getId());
        counterParty.setName(counterPartyDTO.getName());
        counterParty.setAccounts(new AccountMapperImpl().toEntityList(counterPartyDTO.getAccounts()));
        return counterParty;
    }

    public CounterPartyDTO toDTO(CounterParty counterParty) {
        if (counterParty == null) {
            return null;
        }
        CounterPartyDTO counterPartyDTO = new CounterPartyDTO();
        counterPartyDTO.setId(counterParty.getId());
        counterPartyDTO.setName(counterParty.getName());
        counterPartyDTO.setAccounts(new AccountMapperImpl().toDTOList(counterParty.getAccounts()));
        return counterPartyDTO;
    }

    public List<CounterParty> toEntityList(List<CounterPartyDTO> counterPartyDTOList) {
        if (counterPartyDTOList == null) {
            return null;
        }
        List<CounterParty> list = new ArrayList<>();
        for (CounterPartyDTO dto : counterPartyDTOList) {
            list.add(toEntity(dto));
        }
        return list;
    }

    public List<CounterPartyDTO> toDTOList(List<CounterParty> counterPartyList) {
        if (counterPartyList == null) {
            return null;
        }
        List<CounterPartyDTO> list = new ArrayList<>();
        for (CounterParty counterParty : counterPartyList) {
            list.add(toDTO(counterParty));
        }
        return list;

    }
}
