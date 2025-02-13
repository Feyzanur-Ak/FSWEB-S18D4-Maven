package com.workintech.s18d1.entity;


import jakarta.persistence.*;


@Entity
public class Burger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;
    @Column(name="price")
    private double price;

    @Column(name="is_vegan")
    private boolean isVegan;

    @Enumerated(EnumType.STRING)
    private BreadType breadType;
    @Column(name="contents")
    private String contents;



}
