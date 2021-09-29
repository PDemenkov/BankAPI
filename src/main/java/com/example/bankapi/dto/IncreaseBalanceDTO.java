package com.example.bankapi.dto;

import java.util.Objects;

public class IncreaseBalanceDTO {

    int userId;
    int accountId;
    int amount;

    public IncreaseBalanceDTO() {
    }

    public IncreaseBalanceDTO(int userId, int accountId, int amount) {
        this.userId = userId;
        this.accountId = accountId;
        this.amount = amount;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
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
        IncreaseBalanceDTO that = (IncreaseBalanceDTO) o;
        return userId == that.userId && accountId == that.accountId && amount == that.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, accountId, amount);
    }

    @Override
    public String toString() {
        return "IncreaseBalanceDTO{" +
                "userId=" + userId +
                ", accountId=" + accountId +
                ", amount=" + amount +
                '}';
    }
}
