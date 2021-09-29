package com.example.bankapi.mapper.api;

import com.example.bankapi.dto.CounterPartyDTO;
import com.example.bankapi.entity.CounterParty;

import java.util.List;

public interface CounterPartyMapper {

    CounterParty toEntity(CounterPartyDTO counterPartyDTO);

    CounterPartyDTO toDTO(CounterParty counterParty);

    List<CounterParty> toEntityList(List<CounterPartyDTO> counterPartyDTOList);

    List<CounterPartyDTO> toDTOList(List<CounterParty> counterPartyList);
}
