package com.cashvroom.cashvroom.repository;

import com.cashvroom.cashvroom.model.Lootbox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LootboxRepository extends JpaRepository<Lootbox, Long> {

    List<Lootbox> findByName(String name);

    List<Lootbox> findByPriceLessThan(double maxPrice);

    List<Lootbox> findByPriceGreaterThan(double minPrice);

}
