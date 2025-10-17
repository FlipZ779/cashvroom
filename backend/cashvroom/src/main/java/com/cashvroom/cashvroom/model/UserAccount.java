package com.cashvroom.cashvroom.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "user_account")
public class UserAccount {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "name")
    private String name;

    @Column (name = "email")
    private String email;

    @Column (name = "password_hash")
    private String password;

    @Column (name = "balance")
    private double balance;

    @Column (name = "last_update")
    private LocalDateTime lastUpdate;


}

