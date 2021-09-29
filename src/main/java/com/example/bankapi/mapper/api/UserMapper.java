package com.example.bankapi.mapper.api;

import com.example.bankapi.dto.UserDTO;
import com.example.bankapi.entity.User;


public interface UserMapper {

    User toEntity(UserDTO userDTO);

    UserDTO toDTO(User user);
}
