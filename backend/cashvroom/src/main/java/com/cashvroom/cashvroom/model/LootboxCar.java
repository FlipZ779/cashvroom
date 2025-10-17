package com.cashvroom.cashvroom.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "lootbox_car")
public class LootboxCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "lootbox_id")
    private Long lootboxId;

    @Column (name = "car_id")
    private Long carId;

    @Column (name = "probability")
    private float probability;


}
