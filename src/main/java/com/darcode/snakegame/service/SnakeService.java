package com.darcode.snakegame.service;

import com.darcode.snakegame.model.Food;
import com.darcode.snakegame.model.Snake;
import com.darcode.snakegame.repository.SnakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SnakeService {

    private final SnakeRepository snakeRepository;

    @Autowired
    public SnakeService(SnakeRepository snakeRepository) {
        this.snakeRepository = snakeRepository;
    }

    public void updateSnakeColor(Long userId, String newColor) {
        Snake snake = snakeRepository.findByUserid(userId);
        if (snake != null) {
            snake.setSnakecolor(newColor);
            snakeRepository.save(snake);
        } else {
            throw new RuntimeException("Snake not found for user ID: " + userId);
        }
    }

    public String getSnakeColor(Long userId) {
        Snake snake = snakeRepository.findByUserid(userId);
        if (snake != null) {
            return snake.getSnakecolor();
        } else {
            throw new RuntimeException("Snake not found for user ID: " + userId);
        }
    }
}
