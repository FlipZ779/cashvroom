package com.cashvroom.cashvroom.repository;

import com.cashvroom.cashvroom.model.CollectionCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectionCarRepository extends JpaRepository<CollectionCar, Long>{

    List<CollectionCar> findByCollectionId(Long collectionId);
}
