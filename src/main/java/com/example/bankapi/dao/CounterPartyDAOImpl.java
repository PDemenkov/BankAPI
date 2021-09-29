package com.example.bankapi.dao;

import org.springframework.stereotype.Repository;
import com.example.bankapi.entity.CounterParty;
import com.example.bankapi.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CounterPartyDAOImpl implements CounterPartyDAO {

    private final EntityManager entityManager;

    public CounterPartyDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<CounterParty> getAllCounterParties(int userId) {
        Query query = entityManager.createQuery("from User where id = :userId");
        query.setParameter("userId", userId);
        User user = (User) query.getSingleResult();
        return new ArrayList<>(user.getCounterParties());
    }

    @Override
    public void add(int userId, CounterParty counterParty) {
        entityManager.merge(counterParty);
        User existingUser = entityManager.find(User.class, userId);
        existingUser.getCounterParties().add(counterParty);
        entityManager.merge(existingUser);
    }


}
