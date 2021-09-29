package com.example.bankapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;
import com.example.bankapi.dto.CounterPartyDTO;
import com.example.bankapi.dto.CounterPartyTransferDTO;
import com.example.bankapi.service.api.CounterPartyService;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CounterPartyController {

    private final CounterPartyService counterPartyService;

    public CounterPartyController(CounterPartyService counterPartyService) {
        this.counterPartyService = counterPartyService;
    }

    @GetMapping("users/{userId}/counterparties")
    public List<CounterPartyDTO> getCounterParties(@PathVariable int userId) {
        return counterPartyService.getAllCounterParties(userId);
    }

    @PostMapping("users/{userId}/counterparties")
    public void addCounterParty(@PathVariable int userId, @RequestBody CounterPartyDTO counterPartyDTO) {
        counterPartyService.addCounterParty(userId, counterPartyDTO);
    }

    @PutMapping("users/{userid}/counterpart/transfer")
    public void cashTransfer(@RequestBody CounterPartyTransferDTO counterPartyTransferDTO) {
        counterPartyService.cashTransfer(counterPartyTransferDTO.getCounterPartyId(), counterPartyTransferDTO.getAmount());
    }
}
