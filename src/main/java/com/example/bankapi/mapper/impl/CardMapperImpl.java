package com.example.bankapi.mapper.impl;


import org.springframework.stereotype.Component;
import com.example.bankapi.dto.CardDTO;
import com.example.bankapi.entity.Card;
import com.example.bankapi.mapper.api.CardMapper;

import java.util.ArrayList;
import java.util.List;

@Component
public class CardMapperImpl implements CardMapper {

    public Card toEntity(CardDTO cardDTO) {
        if (cardDTO == null) {
            return null;
        }

        Card card = new Card();
        card.setId(cardDTO.getId());
        card.setCardNumber(cardDTO.getCardNumber());
        card.setCVV(cardDTO.getCvv());
        card.setExpDate(cardDTO.getExpDate());

        return card;
    }

    public CardDTO toDTO(Card card) {
        if (card == null) {
            return null;
        }

        CardDTO cardDTO = new CardDTO();
        cardDTO.setId(card.getId());
        cardDTO.setCardNumber(card.getCardNumber());
        cardDTO.setCvv(card.getCVV());
        cardDTO.setExpDate(card.getExpDate());

        return cardDTO;
    }

    public List<Card> toEntityList(List<CardDTO> cardDTOList) {
        if (cardDTOList == null) {
            return null;
        }
        List<Card> list = new ArrayList<>(cardDTOList.size());
        for (CardDTO dto : cardDTOList) {
            list.add(toEntity(dto));
        }
        return list;
    }

    public List<CardDTO> toDTOList(List<Card> cardList) {
        if (cardList == null) {
            return null;
        }
        List<CardDTO> list = new ArrayList<>(cardList.size());
        for (Card card : cardList) {
            list.add(toDTO(card));
        }
        return list;
    }
}


