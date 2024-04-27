package com.darcode.snakegame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.darcode.snakegame.model.Scoreboard;
import com.darcode.snakegame.repository.ScoreboardRepository;

@Service
public class ScoreboardService {

    private final ScoreboardRepository scoreboardRepository;

    @Autowired
    public ScoreboardService(ScoreboardRepository scoreboardRepository) {
        this.scoreboardRepository = scoreboardRepository;
    }

    public void addScore(Scoreboard score) {
        scoreboardRepository.save(score);
    }

    public Long getHighScore(Long userId) {
        return scoreboardRepository.findHighestScoreByUserid(userId);
    }
}
