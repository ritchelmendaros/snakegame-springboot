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
    private String foodtype;
    private String foodcolor;

    public Food() {
    }

    public Food(String foodtype, String foodcolor) {
        this.foodtype = foodtype;
        this.foodcolor = foodcolor;
    }

    public Long getFoodid() {
        return foodid;
    }

    public void setFoodid(Long foodid) {
        this.foodid = foodid;
    }

    public String getFoodtype() {
        return foodtype;
    }

    public void setFoodtype(String foodtype) {
        this.foodtype = foodtype;
    }

    public String getFoodcolor() {
        return foodcolor;
    }

    public void setFoodcolor(String foodcolor) {
        this.foodcolor = foodcolor;
    }

}
