package com.workintech.s18d1.dao;

import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;

import java.util.List;

public interface BurgerDao {


    List<Burger> findAll ();
    Burger save(Burger burger);
    Burger findById(Long id);
    Burger findByPrice(double price);
    Burger findByBreadType(BreadType breadType);
    Burger findByContent(String text);
    Burger update(Burger burger);
    Burger remove(Long id);
}
