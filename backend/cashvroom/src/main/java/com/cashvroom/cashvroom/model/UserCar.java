package com.cashvroom.cashvroom.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user_car")
public class UserCar {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "user_id")
    private Long userId;

    @Column (name = "car_id")
    private Long carId;

    @Column (name = "quantity")
    private int quantity;

    @Column(name = "is_active")
    private boolean active;


}
