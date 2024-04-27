package com.darcode.snakegame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.darcode.snakegame.model.Obstacle;

public interface ObstacleRepository extends JpaRepository<Obstacle, Long>{
    
}
