package com.games.repository;

import com.games.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GamesRepository extends JpaRepository<Game, Integer> {

    Game findByTitle(String title);
}
