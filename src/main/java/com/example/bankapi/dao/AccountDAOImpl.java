package com.example.bankapi.dao;

import org.springframework.stereotype.Repository;
import com.example.bankapi.entity.Account;
import com.example.bankapi.entity.CounterParty;
import com.example.bankapi.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private final EntityManager entityManager;
    public AccountDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Account> getAllAccounts(int userId) {
        Query query = entityManager.createQuery("from User where id = :userId");
        query.setParameter("userId", userId);
        User user = (User) query.getSingleResult();
        return new ArrayList<>(user.getAccounts());
    }

    @Override
    public List<Account> getAllCounterPartyAccounts(int counterPartiId) {
        Query query = entityManager.createQuery("from CounterParty where id = :counterPartiId");
        query.setParameter("counterPartiId", counterPartiId);
        CounterParty counterParty = (CounterParty) query.getSingleResult();
        return new ArrayList<>(counterParty.getAccounts());
    }

    @Override
    public List<Account> getAllAccounts() {
        Query query = entityManager.createQuery("from Account");
        return query.getResultList();
    }

    @Override
    public Account getAccountById(int id) {
        return entityManager.find(Account.class, id);
    }

    @Override
    public void addAccount(int userId, Account account) {
        entityManager.merge(account);
        User existingUser = entityManager.find(User.class, userId);
        existingUser.getAccounts().add(account);
        entityManager.merge(existingUser);
    }

    @Override
    public void addCash(int amount, Account account) {
        Account existingAccount = entityManager.find(Account.class, account.getId());
        existingAccount.setBalance(getBalance(existingAccount.getId()) + amount);
        entityManager.merge(existingAccount);
    }

    @Override
    public Integer getBalance(int accountId) {
        Account account = entityManager.find(Account.class, accountId);
        System.out.println(account.getBalance());
        return account.getBalance();
    }
}
