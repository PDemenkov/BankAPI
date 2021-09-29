package com.example.bankapi.mapper.impl;


import org.springframework.stereotype.Component;
import com.example.bankapi.dto.UserDTO;
import com.example.bankapi.entity.User;
import com.example.bankapi.mapper.api.UserMapper;

@Component
public class UserMapperImpl implements UserMapper {

    public User toEntity(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setAccounts(new AccountMapperImpl().toEntityList(userDTO.getAccounts()));
        user.setCounterParties(new CounterPartyMapperImpl().toEntityList(userDTO.getCounterparties()));
        return user;
    }

    public UserDTO toDTO(User user) {
        if (user == null) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        userDTO.setAccounts(new AccountMapperImpl().toDTOList(user.getAccounts()));
        userDTO.setCounterparties(new CounterPartyMapperImpl().toDTOList(user.getCounterParties()));
        return userDTO;
    }

}
