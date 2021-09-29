package com.example.bankapi.entity;



import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "counter_party")
public class CounterParty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Account> accounts;

    public CounterParty() {
    }

    public CounterParty(int id, String name, List<Account> accounts) {
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

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CounterParty that = (CounterParty) o;
        return id == that.id && name.equals(that.name) && accounts.equals(that.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, accounts);
    }

    @Override
    public String toString() {
        return "CounterParty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
