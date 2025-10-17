package com.cashvroom.cashvroom.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "name")
    private String name;

    @Column (name = "rarity")
    private String rarity;

    @Column (name = "income_per_minute")
    private double incomePerMinute;

    @Column (name = "price")
    private Double price ;

    @Column (name = "image_url")
    private String imgUrl;
}
