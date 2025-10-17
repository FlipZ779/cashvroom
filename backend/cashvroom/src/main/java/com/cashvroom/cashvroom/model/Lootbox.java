package com.cashvroom.cashvroom.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "lootbox")
public class Lootbox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "name")
    private String name;

    @Column (name = "price")
    private double price;

    @Column(name = "collection_requirement_id")
    private int collectionRequirement;



}
