package com.darcode.snakegame.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
public class Food {

    @Id
    @GeneratedValue
    private Long foodid;
    private String foodcolor;
    private Long userid;

    public Food() {
    }

    public Food(Long userid, String foodcolor) {
        this.userid = userid;
        this.foodcolor = foodcolor;
    }

    public Long getFoodid() {
        return foodid;
    }

    public void setFoodid(Long foodid) {
        this.foodid = foodid;
    }

    public String getFoodcolor() {
        return foodcolor;
    }

    public void setFoodcolor(String foodcolor) {
        this.foodcolor = foodcolor;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

}
