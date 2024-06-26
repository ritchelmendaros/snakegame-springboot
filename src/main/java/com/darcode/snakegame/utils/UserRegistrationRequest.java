package com.darcode.snakegame.utils;

public class UserRegistrationRequest {
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String snakeColor;
    private String foodColor;
    private Long score;

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
