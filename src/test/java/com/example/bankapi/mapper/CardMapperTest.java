//package com.example.bankapi.mapper;//package ru.sberbank.task.apitask.mapper;
//
//import org.junit.jupiter.api.Test;
//import com.example.bankapi.dto.CardDTO;
//import com.example.bankapi.entity.Card;
//import com.example.bankapi.mapper.impl.CardMapperImpl;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//class CardMapperTest {
//
//    private final CardMapperImpl cardMapper = new CardMapperImpl();
//
//    @Test
//    void toEntity() {
//        Card card = cardMapper.toEntity(new CardDTO(11 ,"Test","123", "1234"));
//        assertEquals(11, card.getId());
//        assertEquals("Test", card.getCardNumber());
//        assertEquals("123", card.getCVV());
//        assertEquals("1234", card.getExpDate());
//    }
//
//    @Test
//    void toDTO() {
//        CardDTO cardDTO = cardMapper.toDTO(new Card(11,"Test","123", "1234"));
//        assertEquals(11, cardDTO.getId());
//        assertEquals("Test", cardDTO.getCardNumber());
//        assertEquals("123", cardDTO.getCvv());
//        assertEquals("1234", cardDTO.getExpDate());
//    }
//
//    @Test
//    void toEntityList() {
//        List<CardDTO> cards = new ArrayList<>();
//        cards.add(new CardDTO(1,"Test","123","12345"));
//        List<Card> list = cardMapper.toEntityList(cards);
//        assertNotNull(list);
//    }
//
//    @Test
//    void toDTOList() {
//        List<Card> cards = new ArrayList<>();
//        cards.add(new Card(1,"Test","123","12345"));
//        List<CardDTO> list = cardMapper.toDTOList(cards);
//        assertNotNull(list);
//    }
//}