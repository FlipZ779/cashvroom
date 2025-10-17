package com.cashvroom.cashvroom.service;

import com.cashvroom.cashvroom.model.*;

import com.cashvroom.cashvroom.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LootboxService {

    private final UserAccountRepository userAccountRepository;
    private final LootboxRepository lootboxRepository;
    private final CarRepository carRepository;
    private final UserCarRepository userCarRepository;
    private final LootboxCarRepository lootboxCarRepository;


    public LootboxService(UserAccountRepository userAccountRepository, LootboxRepository lootboxRepository, CarRepository carRepository, UserCarRepository userCarRepository, LootboxCarRepository lootboxCarRepository) {
        this.userAccountRepository = userAccountRepository;
        this.lootboxRepository = lootboxRepository;
        this.carRepository = carRepository;
        this.userCarRepository = userCarRepository;
        this.lootboxCarRepository = lootboxCarRepository;
    }

    public Car buyAndOpenLootobox(Long userId, Long lootboxId){
        UserAccount user = userAccountRepository.findById(userId).orElseThrow(() -> new RuntimeException("user not found"));
        Lootbox lootbox = lootboxRepository.findById(lootboxId).orElseThrow(() -> new RuntimeException("lootbox not found"));

        if (user.getBalance() < lootbox.getPrice()){
            throw new RuntimeException("insuficient balance");
        }

        user.setBalance(user.getBalance() - lootbox.getPrice());
        userAccountRepository.save(user);

        List<LootboxCar>lootboxCars = lootboxCarRepository.findByLootboxId(lootboxId);
        if (lootboxCars.isEmpty()){
            throw new RuntimeException("No cars linked to this lootbox");
        }

        Car rewardedCar = getRandomCar(lootboxCars);

        UserCar userCar = new UserCar();
        userCar.setId(user.getId());
        userCar.setCarId(rewardedCar.getId());
        userCarRepository.save(userCar);

        return rewardedCar;


    }

    private Car getRandomCar(List<LootboxCar> lootboxCars){

        double random = Math.random() * 100;
        double cumulative= 0.0;

        for (LootboxCar lootboxCar : lootboxCars){
            cumulative += lootboxCar.getProbability();
            if (random <= cumulative){
                return carRepository.findById(lootboxCar.getCarId()).orElseThrow(() -> new RuntimeException("car not found"));
            }
        }

        LootboxCar fallback = lootboxCars.get(lootboxCars.size() - 1);
        return carRepository.findById(fallback.getCarId()).orElseThrow(()-> new RuntimeException("Fallback car not found"));
    }
}


