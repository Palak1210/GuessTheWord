package com.example.guesstheword.controllers;

import com.example.guesstheword.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/game")
public class GameController {

    @Autowired
    GameService gameService;

    @GetMapping("/home")
    public String gameHomePage(@RequestParam(value = "guessChar",required = false) Character guessedChar, Model model){
        String str = "";
        str = gameService.getRandomWord();

        if(guessedChar!=null) {
            gameService.checkGuess(guessedChar);
            str = gameService.getRandomWord();
        }
        model.addAttribute("randomWord",str);
        return "game-home-page";
    }
}
