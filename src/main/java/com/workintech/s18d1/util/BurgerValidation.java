package com.workintech.s18d1.util;

import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.exceptions.BurgerException;
import org.springframework.http.HttpStatus;

public class BurgerValidation {

    public static void validateBurgerPrice(double price) {
        if (price <= 0) {
            throw new BurgerException("Price must be greater than 0", HttpStatus.BAD_REQUEST);
        }
    }

    public static void validateBurgerContent(String content) {
        if (content == null || content.isEmpty()) {
            throw new BurgerException("Content cannot be null or empty", HttpStatus.BAD_REQUEST);
        }
    }

    public static void validateBurger(Burger burger) {
        if (burger == null) {
            throw new BurgerException("Burger cannot be null", HttpStatus.BAD_REQUEST);
        }
        validateBurgerPrice(burger.getPrice());
        validateBurgerContent(burger.getContents());
    }
}
