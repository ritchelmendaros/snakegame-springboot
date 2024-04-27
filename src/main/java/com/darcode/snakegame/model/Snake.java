package com.darcode.snakegame.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
public class Snake {

    @Id
    @GeneratedValue
    private Long snakeid;
    private String snakecolor;
    private Long userid;

    public Snake() {
    }

    public Snake(String snakecolor, Long userid) {
        this.snakecolor = snakecolor;
        this.userid = userid;
    }

    public Long getSnakeid() {
        return snakeid;
    }

    public void setSnakeid(Long snakeid) {
        this.snakeid = snakeid;
    }

    public String getSnakecolor() {
        return snakecolor;
    }

    public void setSnakecolor(String snakecolor) {
        this.snakecolor = snakecolor;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

}
