package com.cashvroom.cashvroom.repository;


import com.cashvroom.cashvroom.model.CollectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectionEntityRepository extends JpaRepository<CollectionEntity, Long>{

    List<CollectionEntity> findByName(String name);

}
