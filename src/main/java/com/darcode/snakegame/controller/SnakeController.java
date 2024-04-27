package com.darcode.snakegame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.darcode.snakegame.model.Snake;
import com.darcode.snakegame.service.SnakeService;

@RestController
@RequestMapping("/snake")
public class SnakeController {

    private final SnakeService snakeService;

    @Autowired
    public SnakeController(SnakeService snakeService) {
        this.snakeService = snakeService;
    }

    @PutMapping("/updateColor")
    public ResponseEntity<?> updateSnakeColor(@RequestBody Snake snake) {
        try {
            snakeService.updateSnakeColor(snake.getUserid(), snake.getSnakecolor());
            return ResponseEntity.ok("Snake color updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error updating snake color: " + e.getMessage());
        }
    }
}
