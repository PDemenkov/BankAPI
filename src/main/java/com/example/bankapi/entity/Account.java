package com.example.bankapi.entity;



import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "account_number")
    String accountNumber;

    @Column(name = "balance")
    int balance;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Card> cards;

    public List<Card> getCards() {
        return cards;
    }

    public Account() {
    }

    public Account(int id, String accountNumber, int balance, List<Card> cards) {
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

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id && balance == account.balance && accountNumber.equals(account.accountNumber) && cards.equals(account.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountNumber, balance, cards);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", cards=" + cards +
                '}';
    }
}
