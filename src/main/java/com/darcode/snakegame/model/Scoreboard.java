package com.darcode.snakegame.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Scoreboard {

    @Id
    @GeneratedValue
    private Long gameid;

    private Long score;

    @ManyToOne
    private User user;

    public Scoreboard() {
    }

    public Scoreboard(User user, Long score) {
        this.user = user;
        this.score = score;
    }

    public Scoreboard(Long userId, Long score) {
        this.user = new User();
        this.user.setUserid(userId);
        this.score = score;
    }

    // Getters and setters
    public Long getGameid() {
        return gameid;
    }

    public void setGameid(Long gameid) {
        this.gameid = gameid;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
