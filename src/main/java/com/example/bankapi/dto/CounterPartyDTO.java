package com.example.bankapi.dto;

import java.util.List;
import java.util.Objects;

public class CounterPartyDTO {

    private int id;
    private String name;
    private List<AccountDTO> accounts;

    public CounterPartyDTO() {
    }

    public CounterPartyDTO(int id, String name, List<AccountDTO> accounts) {
        this.id = id;
        this.name = name;
        this.accounts = accounts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AccountDTO> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountDTO> accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CounterPartyDTO that = (CounterPartyDTO) o;
        return id == that.id && name.equals(that.name) && accounts.equals(that.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, accounts);
    }

    @Override
    public String toString() {
        return "CounterPartyDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
