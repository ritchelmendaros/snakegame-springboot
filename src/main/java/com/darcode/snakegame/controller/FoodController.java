package com.darcode.snakegame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.darcode.snakegame.model.Food;
import com.darcode.snakegame.service.FoodService;

@RestController
@RequestMapping("/food")
public class FoodController {

    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PutMapping("/updateColor")
    public ResponseEntity<?> updateFoodColor(@RequestBody Food food) {
        try {
            foodService.updateFoodColor(food.getUserid(), food.getFoodcolor());
            return ResponseEntity.ok("Food color updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error updating food color: " + e.getMessage());
        }
    }
}
