package com.games.controller;

import com.games.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameController {

    @Autowired
    private GameService service;

    @GetMapping("/games")
    public String myGames(Model model) {
        model.addAttribute("games", service.getGames());
        return "games";
    }
}
