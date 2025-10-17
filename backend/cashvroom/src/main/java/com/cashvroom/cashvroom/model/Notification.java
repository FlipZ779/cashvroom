package com.cashvroom.cashvroom.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "notification" )
public class Notification {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "user_id")
    private long userId;

    @Column (name = "message")
    private String message;

    @Column (name = "is_Read")
    private boolean read;

    @Column(name = "timestamp")
    private LocalDateTime timeStamp;


}
