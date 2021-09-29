package com.example.bankapi.dto;

import java.util.List;
import java.util.Objects;


public class AccountDTO {

    private int id;
    private String accountNumber;
    private int balance;
    private List<CardDTO> cards;

    public AccountDTO() {
    }

    public AccountDTO(int id, String accountNumber, int balance, List<CardDTO> cards) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.cards = cards;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public List<CardDTO> getCards() {
        return cards;
    }

    public void setCards(List<CardDTO> cards) {
        this.cards = cards;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountDTO that = (AccountDTO) o;
        return id == that.id && balance == that.balance && accountNumber.equals(that.accountNumber) && cards.equals(that.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountNumber, balance, cards);
    }

    @Override
    public String toString() {
        return "AccountDTO{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", cards=" + cards +
                '}';
    }
}