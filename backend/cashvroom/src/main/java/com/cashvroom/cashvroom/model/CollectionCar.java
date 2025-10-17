package com.cashvroom.cashvroom.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "collection_car")
public class CollectionCar {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "collection_id")
    private Long collectionId;

    @Column (name = "car_id")
    private Long carId;

}
