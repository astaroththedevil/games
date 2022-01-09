package com.games.controller;

import com.games.model.Game;
import com.games.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {

    @Autowired
    private GameService service;

    @GetMapping("/allgames")
    public List<Game> findAllGames() {
        return service.getGames();
    }

    @GetMapping("/gameById/{id}")
    public Game findGameById(@PathVariable Integer id) {
        return service.getGameById(id);
    }

    @GetMapping("/gameByName/{title}")
    public Game findGameByTitle(@PathVariable String title) {
        return service.getGameByTitle(title);
    }

    @PostMapping("/addgame")
    public Game addGame(@RequestBody Game game) {
        return service.addGame(game);
    }

    @PostMapping("/addgames")
    public List<Game> addGames(@RequestBody List<Game> games) {
        return service.addGames(games);
    }

    @PutMapping("/update/{id}")
    public Game updateGame(@RequestBody Game game, @PathVariable Integer id) {
        return service.updateGame(game, id);
    }

    @DeleteMapping("/deletegame/{id}")
    public String deleteGame(@PathVariable Integer id) {
        return service.deleteGameById(id);
    }

    @DeleteMapping("/deletegames")
    public String deleteAllGames() {
        return service.deleteAllGames();
    }
}
