package com.workintech.s18d1.dao;

import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BurgerDaoImpl implements BurgerDao {


    private EntityManager entityManager;

    @Autowired
    public BurgerDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Burger> findAll() {
        TypedQuery<Burger> query=entityManager.createQuery("SELECT b FROM Burger b", Burger.class);
        return query.getResultList();
    }

    @Override
    public Burger save(Burger burger) {
        return null;
    }

    @Override
    public Burger findById(Long id) {
        return null;
    }

    @Override
    public Burger findByPrice(double price) {
        return null;
    }

    @Override
    public Burger findByBreadType(BreadType breadType) {
        return null;
    }

    @Override
    public Burger findByContent(String text) {
        return null;
    }

    @Override
    public Burger update(Burger burger) {
        return null;
    }

    @Override
    public Burger remove(Long id) {
        return null;
    }
}
