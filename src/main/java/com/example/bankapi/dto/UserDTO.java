package com.example.bankapi.dto;

import java.util.List;
import java.util.Objects;

public class UserDTO {

    private int id;
    private String name;
    private String surname;
    private List<AccountDTO> accounts;
    private List<CounterPartyDTO> counterparties;

    public UserDTO() {
    }

    public UserDTO(int id, String name, String surname, List<AccountDTO> accounts, List<CounterPartyDTO> counterparties) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.accounts = accounts;
        this.counterparties = counterparties;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<AccountDTO> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountDTO> accounts) {
        this.accounts = accounts;
    }

    public List<CounterPartyDTO> getCounterparties() {
        return counterparties;
    }

    public void setCounterparties(List<CounterPartyDTO> counterparties) {
        this.counterparties = counterparties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return id == userDTO.id && name.equals(userDTO.name) && surname.equals(userDTO.surname) && accounts.equals(userDTO.accounts) && counterparties.equals(userDTO.counterparties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, accounts, counterparties);
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", accounts=" + accounts +
                ", counterparties=" + counterparties +
                '}';
    }
}
