package com.example.bankapi.mapper;

import org.junit.jupiter.api.Test;
import com.example.bankapi.dto.UserDTO;
import com.example.bankapi.entity.User;
import com.example.bankapi.mapper.impl.UserMapperImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class UserMapperTest {

    private final UserMapperImpl userMapper = new UserMapperImpl();

    @Test
    void toEntity() {
        User user = userMapper.toEntity(new UserDTO(1,"Test", "Test", null,null));
        assertEquals(1, user.getId());
        assertEquals("Test", user.getName());
        assertEquals("Test", user.getSurname());
        assertNull(user.getAccounts());
        assertNull(user.getCounterParties());
    }

    @Test
    void toDTO() {
        UserDTO userDTO = userMapper.toDTO(new User(1,"Test", "Test", null,null));
        assertEquals(1, userDTO.getId());
        assertEquals("Test", userDTO.getName());
        assertEquals("Test", userDTO.getSurname());
        assertNull(userDTO.getAccounts());
        assertNull(userDTO.getCounterparties());
    }
}