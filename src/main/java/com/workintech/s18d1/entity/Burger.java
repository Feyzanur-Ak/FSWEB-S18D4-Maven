package com.workintech.s18d1.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Burger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;
    @Column(name="price")
    private Double price;

    @Column(name="is_vegan")
    private boolean isVegan;

    @Enumerated(EnumType.STRING)
    private BreadType breadType;
    @Column(name="contents")
    private String contents;

    public boolean getIsVegan() {
        return this.isVegan;
    }

    public void setIsVegan(final boolean isVegan) {
        this.isVegan = isVegan;
    }
}
