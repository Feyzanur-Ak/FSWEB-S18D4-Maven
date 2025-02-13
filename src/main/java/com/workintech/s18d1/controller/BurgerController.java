package com.workintech.s18d1.controller;

import com.workintech.s18d1.dao.BurgerDaoImpl;
import com.workintech.s18d1.entity.Burger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public class BurgerController {


    private final BurgerDaoImpl burgerDaoImpl;

    @Autowired
    public BurgerController(BurgerDaoImpl burgerDaoImpl) {
        this.burgerDaoImpl = burgerDaoImpl;
    }


    @GetMapping()
    public List<Burger> findAll(){
        return  burgerDaoImpl.findAll();
    }

    @GetMapping("/{id}")
    public Burger getById(@PathVariable  Long id){
        return  burgerDaoImpl.findById(id);
    }


    @PostMapping()
    public Burger burgerUpdate(Burger burger){
        return  burgerDaoImpl.update(burger);
    }
}
