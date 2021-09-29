package com.example.bankapi.controller;

import org.springframework.web.bind.annotation.*;
import com.example.bankapi.dto.CardDTO;
import com.example.bankapi.dto.UserDTO;
import com.example.bankapi.dto.IncreaseBalanceDTO;
import com.example.bankapi.service.api.UserService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{userId}")
    public UserDTO getUserById(@PathVariable int userId) {
        return userService.getUserById(userId);
    }

    @PostMapping("/users")
    public List<UserDTO> addUser(@RequestBody UserDTO userDTO) {
        userService.addUser(userDTO);
        return userService.getAllUsers();
    }

    @GetMapping("users/{userId}/cards")
    public List<CardDTO> getAllCards(@PathVariable String userId) {
        return userService.getAllCards(Integer.parseInt(userId));
    }

    @PutMapping("users/{userId}/adds")
    public void addCash(@RequestBody IncreaseBalanceDTO increaseBalanceDTO) {
        userService.addCash(increaseBalanceDTO.getAccountId(), increaseBalanceDTO.getAmount());
    }


}
