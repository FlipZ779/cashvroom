package com.cashvroom.cashvroom.repository;

import com.cashvroom.cashvroom.model.UserCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCarRepository extends JpaRepository<UserCar, Long> {
    List<UserCar> findByActive(boolean active);
}
