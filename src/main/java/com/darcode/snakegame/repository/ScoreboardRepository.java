package com.darcode.snakegame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.darcode.snakegame.model.Scoreboard;

public interface ScoreboardRepository extends JpaRepository<Scoreboard, Long>{
    
}
