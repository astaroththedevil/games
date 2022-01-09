package com.games.service;

import com.games.model.Game;
import com.games.repository.GamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GamesRepository repository;

    public List<Game> getGames() {
        return repository.findAll();
    }

    public Game getGameById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Game getGameByTitle(String title) {
        return repository.findByTitle(title);
    }

    public Game addGame(Game game) {
        return repository.save(game);
    }

    public List<Game> addGames(List <Game> games) {
        return repository.saveAll(games);
    }

    public Game updateGame(Game game, Integer id) {
        Game existingGame = repository.findById(id).orElse(null);
        existingGame.setTitle(game.getTitle());
        existingGame.setDeveloper(game.getDeveloper());
        existingGame.setGenre(game.getGenre());
        existingGame.setYearOfRelease(game.getYearOfRelease());
        existingGame.setPrice(game.getPrice());
        return repository.save(existingGame);
    }

    public String deleteGameById(Integer id) {
        repository.deleteById(id);
        return "Game with id " + id + " has been successfully removed!";
    }

    public String deleteAllGames() {
        repository.deleteAll();
        return "All games have been successfully removed!";
    }
}
