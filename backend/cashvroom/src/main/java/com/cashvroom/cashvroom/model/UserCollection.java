package com.cashvroom.cashvroom.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user_collection")
public class UserCollection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column (name = "collection_id")
    private Long collectionId;

    @Column (name = "cars_collected")
    private int carsCollected;

}
