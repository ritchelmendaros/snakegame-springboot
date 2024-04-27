package com.darcode.snakegame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darcode.snakegame.model.Food;
import com.darcode.snakegame.repository.FoodRepository;

@Service
public class FoodService {

    private final FoodRepository foodRepository;

    @Autowired
    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public void updateFoodColor(Long foodId, String foodColor) {
        Food food = foodRepository.findById(foodId)
                .orElseThrow(() -> new RuntimeException("Food not found with id: " + foodId));
        food.setFoodcolor(foodColor);
        foodRepository.save(food);
    }
}
