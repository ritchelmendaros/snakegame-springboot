package com.darcode.snakegame.utils;

import com.darcode.snakegame.model.User;

public class UserRegistrationRequest {
    private User user;
    private String snakeColor;
    private String foodColor;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSnakeColor() {
        return snakeColor;
    }

    public void setSnakeColor(String snakeColor) {
        this.snakeColor = snakeColor;
    }

    public String getFoodColor() {
        return foodColor;
    }

    public void setFoodColor(String foodColor) {
        this.foodColor = foodColor;
    }

}
