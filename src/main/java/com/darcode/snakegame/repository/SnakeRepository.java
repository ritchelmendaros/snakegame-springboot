package com.darcode.snakegame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.darcode.snakegame.model.Snake;

public interface SnakeRepository extends JpaRepository<Snake, Long> {

    Snake findByUserid(Long userId);

}
