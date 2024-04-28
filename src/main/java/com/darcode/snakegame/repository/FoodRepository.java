package com.darcode.snakegame.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.darcode.snakegame.model.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {

    Optional<Food> findByUserid(Long userid);

}
