package com.example.bankapi.dto;


import java.util.Objects;

public class CounterPartyTransferDTO {

    int userId;
    int counterPartyId;
    int amount;

    public CounterPartyTransferDTO() {
    }

    public CounterPartyTransferDTO(int userId, int counterPartyId, int amount) {
        this.userId = userId;
        this.counterPartyId = counterPartyId;
        this.amount = amount;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCounterPartyId() {
        return counterPartyId;
    }

    public void setCounterPartyId(int counterPartyId) {
        this.counterPartyId = counterPartyId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CounterPartyTransferDTO that = (CounterPartyTransferDTO) o;
        return userId == that.userId && counterPartyId == that.counterPartyId && amount == that.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, counterPartyId, amount);
    }

    @Override
    public String toString() {
        return "CounterPartyTransferDTO{" +
                "userId=" + userId +
                ", counterPartyId=" + counterPartyId +
                ", amount=" + amount +
                '}';
    }
}
