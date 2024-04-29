package com.darcode.snakegame.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darcode.snakegame.UserScoreDTO;
import com.darcode.snakegame.model.Scoreboard;
import com.darcode.snakegame.model.User;
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
}
