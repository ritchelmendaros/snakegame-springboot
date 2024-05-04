package com.darcode.snakegame.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.darcode.snakegame.model.Scoreboard;
import com.darcode.snakegame.service.ScoreboardService;

@RestController
@RequestMapping("/scoreboard")
public class ScoreboardController {

    private final ScoreboardService scoreboardService;

    @Autowired
    public ScoreboardController(ScoreboardService scoreboardService) {
        this.scoreboardService = scoreboardService;
    }

    @PostMapping("/addScore")
    public ResponseEntity<?> addScoreToScoreboard(@RequestBody Scoreboard score) {
        try {
            scoreboardService.addScore(score);
            return ResponseEntity.ok("Score added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error adding score: " + e.getMessage());
        }
    }

    @GetMapping("/getHighScore")
    public ResponseEntity<?> getHighScore(@RequestParam(name = "userId") Long userId) {
        try {
            Long highScore = scoreboardService.getHighScore(userId);
            return ResponseEntity.ok(highScore);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error retrieving high score: " + e.getMessage());
        }
    }

    @GetMapping("/leaderboard")
    public ResponseEntity<?> getLeaderboard() {
        try {
            List<Scoreboard> leaderboard = scoreboardService.getLeaderboard();
            return ResponseEntity.ok(leaderboard);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error retrieving leaderboard: " + e.getMessage());
        }
    }

    @PutMapping("/updateScore")
    public ResponseEntity<?> updateScoreOnScoreboard(@RequestBody Scoreboard score) {
        try {
            scoreboardService.updateScore(score.getUserid(), score.getScore());
            return ResponseEntity.ok("Score updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error updating score: " + e.getMessage());
        }
    }
}
