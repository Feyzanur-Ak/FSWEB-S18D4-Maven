package com.workintech.s18d1.controller;

import com.workintech.s18d1.dao.BurgerDaoImpl;
import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.exceptions.BurgerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
    public Burger burgerUpdate(@RequestBody Burger burger){
        return  burgerDaoImpl.update(burger);
    }

    @PutMapping("/{id}")
    public Burger update(@PathVariable Long id, @RequestBody Burger burger)
    {
       Burger existingBurger=burgerDaoImpl.findById(id);
       if(existingBurger== null)
       {
           throw new BurgerException("Burger not found with ID: " + id, HttpStatus.NOT_FOUND);
       }
        burger.setId(id);
       return burgerDaoImpl.update(burger);
    }

    @DeleteMapping("/{id}")
    public Burger delete(@PathVariable Long id,@RequestBody Burger burger){
        Burger deletedBurger=burgerDaoImpl.findById(id);
        if(deletedBurger == null){
            throw new BurgerException("Id nor found",HttpStatus.NOT_FOUND);
        }
        burgerDaoImpl.remove(id);
        return burgerDaoImpl.update(burger);
    }
    @GetMapping("/findByPrice")
    public List<Burger> findByPrice(@RequestBody double price) {
        return burgerDaoImpl.findByPrice(price);
    }

    @GetMapping("/findByBreadType")
    public List<Burger> findByBreadType(@RequestBody BreadType breadType) {
        return burgerDaoImpl.findByBreadType(breadType);
    }

    @GetMapping("/findByContent")
    public List<Burger> findByContent(@RequestBody String content) {
        return burgerDaoImpl.findByContent(content);
    }
}

