package com.example.bankapi.entity;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Account> accounts;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CounterParty> counterParties;

    public User() {
    }

    public User(int id, String name, String surname, List<Account> accounts, List<CounterParty> counterParties) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.accounts = accounts;
        this.counterParties = counterParties;
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

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<CounterParty> getCounterParties() {
        return counterParties;
    }

    public void setCounterParties(List<CounterParty> counterParties) {
        this.counterParties = counterParties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && name.equals(user.name) && surname.equals(user.surname) && accounts.equals(user.accounts) && counterParties.equals(user.counterParties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, accounts, counterParties);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", accounts=" + accounts +
                ", counterParties=" + counterParties +
                '}';
    }
}
