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

    public Snake() {
    }

    public Snake(String snakecolor) {
        this.snakecolor = snakecolor;
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

}
