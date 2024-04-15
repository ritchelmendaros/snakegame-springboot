package com.darcode.snakegame.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
public class Obstacle {

    @Id
    @GeneratedValue
    private Long obstacleid;
    private String obstacletype;

    public Obstacle() {
    }

    public Obstacle(String obstacletype) {
        this.obstacletype = obstacletype;
    }

    public Long getObstacleid() {
        return obstacleid;
    }

    public void setObstacleid(Long obstacleid) {
        this.obstacleid = obstacleid;
    }

    public String getObstacletype() {
        return obstacletype;
    }

    public void setObstacletype(String obstacletype) {
        this.obstacletype = obstacletype;
    }

}
