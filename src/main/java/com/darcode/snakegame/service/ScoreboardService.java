package com.darcode.snakegame.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darcode.snakegame.model.Scoreboard;
import com.darcode.snakegame.repository.ScoreboardRepository;
import com.darcode.snakegame.repository.UserRepository;

@Service
public class ScoreboardService {

    private final ScoreboardRepository scoreboardRepository;
    private final UserRepository userRepository;

    @Autowired
    public ScoreboardService(ScoreboardRepository scoreboardRepository, UserRepository userRepository) {
        this.scoreboardRepository = scoreboardRepository;
        this.userRepository = userRepository;
    }

    public void addScore(Scoreboard score) {
        scoreboardRepository.save(score);
    }

    public Long getHighScore(Long userId) {
        return scoreboardRepository.findHighestScoreByUserid(userId);
    }

    public List<Scoreboard> getLeaderboard() {
        return scoreboardRepository.findAllByOrderByScoreDesc();
    }

    public void updateScore(Long userId, Long newScore) {
        Scoreboard existingScore = (Scoreboard) scoreboardRepository.findByUserid(userId);
        if (existingScore == null) {
            throw new NoSuchElementException("Score with UserID " + userId + " not found");
        }
        existingScore.setScore(newScore);
        scoreboardRepository.save(existingScore);
    }

    public Long getScore(Long userId) {
        Scoreboard existingScore = (Scoreboard) scoreboardRepository.findByUserid(userId);
        return existingScore != null ? existingScore.getScore() : 0L;
    }
}
