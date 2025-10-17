package com.cashvroom.cashvroom.repository;

import com.cashvroom.cashvroom.model.LootboxCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LootboxCarRepository extends JpaRepository<LootboxCar, Long> {

    List<LootboxCar> findByLootboxId(Long lootboxId);

    List<LootboxCar> findByCarId(Long CarId);

    List<LootboxCar> findByProbability(float probability);

}
