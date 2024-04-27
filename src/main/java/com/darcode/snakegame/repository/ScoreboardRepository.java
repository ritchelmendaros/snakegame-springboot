package com.darcode.snakegame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.darcode.snakegame.model.Scoreboard;

public interface ScoreboardRepository extends JpaRepository<Scoreboard, Long> {

    @Query("SELECT MAX(s.score) FROM Scoreboard s WHERE s.userid = :userid")
    Long findHighestScoreByUserid(@Param("userid") Long userid);
}
