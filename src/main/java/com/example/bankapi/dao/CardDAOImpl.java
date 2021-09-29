package com.example.bankapi.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.bankapi.entity.Account;
import com.example.bankapi.entity.Card;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CardDAOImpl implements CardDAO {

    private final EntityManager entityManager;

    public CardDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Card> getAllCards(int accountId) {
        Query query = entityManager.createQuery("from Account where id = :accountId");
        query.setParameter("accountId", accountId);
        Account account = (Account) query.getSingleResult();
        return new ArrayList<>(account.getCards());
    }

    @Override
    @Transactional
    public void addCard(int accountId, Card card) {
        entityManager.merge(card);
        Account existingAccount = entityManager.find(Account.class, accountId);
        existingAccount.getCards().add(card);
        entityManager.merge(existingAccount);
    }
}
