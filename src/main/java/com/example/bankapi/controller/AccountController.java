package com.example.bankapi.controller;


import org.springframework.web.bind.annotation.*;
import com.example.bankapi.dao.AccountDAO;
import com.example.bankapi.dto.AccountDTO;
import com.example.bankapi.dto.CardDTO;
import com.example.bankapi.service.api.AccountService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountDAO accountDAO, AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/account")
    public List<AccountDTO> getAllAccounts() {
        return accountService.getAllAccounts();
    }


    @GetMapping("/account/{accountID}")
    public AccountDTO getAccount(@PathVariable int accountID) {
        return accountService.getAccountByID(accountID);
    }

    @GetMapping("/account/{accountId}/balance")
    public Integer getBalance(@PathVariable int accountId) {
        return accountService.getBalance(accountId);
    }

    @PostMapping("/account/{accountID}/addcard")
    public void addCard(@PathVariable int accountID, @RequestBody CardDTO cardDTO) {
        accountService.addCard(accountID, cardDTO);

    }


}
