package com.example.guesstheword.controllers;

import com.example.guesstheword.service.GameService;
import com.example.guesstheword.utils.GameUtils;
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
    private GameService gameService;

    @Autowired
    private GameUtils gameUtils;


    @GetMapping("/home")
    public String gameHomePage(@RequestParam(value = "guessChar",required = false) Character guessedChar, Model model){
        String str;
        boolean isGuessed;
        str = gameService.getRandomWord();
        if(guessedChar!=null) {
            isGuessed = gameService.checkGuess(guessedChar);
            str = gameService.getRandomWord();

            if(!isGuessed){
                gameUtils.reduceTries();
            }
        }
        model.addAttribute("randomWord",str);
        model.addAttribute("tries",gameUtils.getRemainingTries());
        return "game-home-page";
    }

    @GetMapping("/reload")
    public String reloadGame(){
        gameService = gameUtils.getGameService();
        gameUtils.resetTries();
        return "redirect:/game/home";
    }
}
