package com.darcode.snakegame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.darcode.snakegame.model.Food;

public interface FoodRepository extends JpaRepository<Food, Long>{
    
}
