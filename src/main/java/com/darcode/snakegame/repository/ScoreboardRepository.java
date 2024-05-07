package com.darcode.snakegame.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.darcode.snakegame.model.Scoreboard;

public interface ScoreboardRepository extends JpaRepository<Scoreboard, Long> {

    @Query("SELECT MAX(s.score) FROM Scoreboard s WHERE s.user.userid = :userId")
    Long findHighestScoreByUserId(@Param("userId") Long userId);

    List<Scoreboard> findAllByOrderByScoreDesc();

    Scoreboard findByUser_Userid(Long userId);
}
