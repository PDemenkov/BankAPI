package com.example.bankapi.mapper.api;

import com.example.bankapi.dto.CardDTO;
import com.example.bankapi.entity.Card;

import java.util.List;

public interface CardMapper {

    Card toEntity(CardDTO cardDTO);

    CardDTO toDTO(Card card);

    List<Card> toEntityList(List<CardDTO> cardDTOList);

    List<CardDTO> toDTOList(List<Card> cardList);
}
