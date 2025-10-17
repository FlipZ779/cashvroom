package com.cashvroom.cashvroom.repository;


import com.cashvroom.cashvroom.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {


    List<Car> findByName(String name);

    List<Car> findByRarity(String rarity);

    List<Car> findByIncomePerMinuteGreaterThan(double minIncome);

    List<Car> findByPriceLessThan(double maxPrice);

}
