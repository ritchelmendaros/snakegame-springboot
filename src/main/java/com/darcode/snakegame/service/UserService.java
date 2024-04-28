package com.darcode.snakegame.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.darcode.snakegame.UserRegistrationRequest;
import com.darcode.snakegame.model.Food;
import com.darcode.snakegame.model.Scoreboard;
import com.darcode.snakegame.model.Snake;
import com.darcode.snakegame.model.User;
import com.darcode.snakegame.repository.FoodRepository;
import com.darcode.snakegame.repository.ScoreboardRepository;
import com.darcode.snakegame.repository.SnakeRepository;
import com.darcode.snakegame.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final SnakeRepository snakeRepository;
    private final FoodRepository foodRepository;
    private final ScoreboardRepository scoreboardRepository;

    @Autowired
    public UserService(UserRepository userRepository, SnakeRepository snakeRepository, FoodRepository foodRepository,
            ScoreboardRepository scoreboardRepository) {
        this.userRepository = userRepository;
        this.foodRepository = foodRepository;
        this.snakeRepository = snakeRepository;
        this.scoreboardRepository = scoreboardRepository;
    }

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public User register(User dto) {
        return userRepository.save(dto);
    }

    public void registerUserWithDefaults(UserRegistrationRequest request) {
        User user = new User(request.getFirstname(), request.getLastname(), request.getUsername(),
                request.getPassword());
        User savedUser = userRepository.save(user);

        String snakeColor = "#0000FF";
        String foodColor = "#FF0000";

        Snake snake = new Snake(snakeColor, savedUser.getUserid());
        snakeRepository.save(snake);

        Food food = new Food(savedUser.getUserid(), foodColor);
        foodRepository.save(food);

        Scoreboard scoreboard = new Scoreboard(savedUser.getUserid(), 0L);
        scoreboardRepository.save(scoreboard);
    }

    public User findByUsername(String username, String password) {
        try {
            Optional<User> userOptional = userRepository.findByUsername(username);
            if (userOptional.isPresent()) {
                User user = userOptional.get();
                if (user.getPassword().equals(password)) {
                    return user;
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } catch (DataAccessException e) {
            System.err.println("Error occurred while finding user by username: " + e.getMessage());
            throw new RuntimeException("Error finding user by username: " + e.getMessage());
        }
    }

    public Long getUserIdByUsername(String username) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional != null) {
            User user = userOptional.get();
            return user.getUserid();
        }
        return null;
    }
}
