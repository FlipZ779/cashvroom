package com.cashvroom.cashvroom.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "transactions")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "user_id")
    private Long userId;

    @Column (name = "type")
    private String type;

    @Lob
    @Column(columnDefinition = "text")
    private String description;

    @Column (name = "value")
    private double value;

    @Column(name = "timestamp")
    @CreationTimestamp
    private LocalDateTime timestamp;


}
