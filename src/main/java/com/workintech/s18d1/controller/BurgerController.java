package com.workintech.s18d1.controller;


import com.workintech.s18d1.dao.BurgerDao;
import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.exceptions.BurgerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/burger") // Tüm endpoint'ler için base URL
public class BurgerController {

    private final BurgerDao burgerDao;

    @Autowired
    public BurgerController(BurgerDao burgerDao) {
        this.burgerDao = burgerDao; // BurgerDaoImpl yerine BurgerDao kullanılıyor
    }

    @GetMapping
    public List<Burger> findAll() {
        return burgerDao.findAll();
    }

    @GetMapping("/{id}")
    public Burger getById(@PathVariable Long id) {
        return burgerDao.findById(id);
    }

    @PostMapping
    public Burger saveBurger(@RequestBody Burger burger) {
        return burgerDao.save(burger);
    }

    @PutMapping("/{id}")
    public Burger update(@PathVariable Long id, @RequestBody Burger burger) {
        Burger existingBurger = burgerDao.findById(id);
        if (existingBurger == null) {
            throw new BurgerException("Burger not found with ID: " + id, HttpStatus.NOT_FOUND);
        }
        burger.setId(id);
        return burgerDao.update(burger);
    }

    @DeleteMapping("/{id}")
    public Burger delete(@PathVariable Long id) {
        // Veri tabanında mevcut burger kontrolü
        Burger existingBurger = burgerDao.findById(id);
        if (existingBurger == null) {
            throw new BurgerException("Burger not found with ID: " + id, HttpStatus.NOT_FOUND);
        }

        // Silme işlemi
        burgerDao.remove(id);

        // Silinen burger'i döndür
        return existingBurger;
    }

    @GetMapping("/price/{price}")
    public List<Burger> findByPrice(@PathVariable double price) {
        return burgerDao.findByPrice(price);
    }

    @GetMapping("/breadType/{breadType}")
    public List<Burger> findByBreadType(@PathVariable BreadType breadType) {
        return burgerDao.findByBreadType(breadType);
    }

    @GetMapping("/content/{content}")
    public List<Burger> findByContent(@PathVariable String content) {
        return burgerDao.findByContent(content);
    }

}

