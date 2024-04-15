package com.darcode.snakegame.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
public class Scoreboard {

    @Id
    @GeneratedValue
    private Long gameid;
    private Long userid;
    private Long score;

    public Scoreboard() {
    }

    public Scoreboard(Long userid, Long score) {
        this.userid = userid;
        this.score = score;
    }

    public Long getGameid() {
        return gameid;
    }

    public void setGameid(Long gameid) {
        this.gameid = gameid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

}
