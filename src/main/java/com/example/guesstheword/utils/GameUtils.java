package com.example.guesstheword.utils;

import com.example.guesstheword.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class GameUtils {
    private int MAX_TRIES = 5;

    @Autowired
    ConfigurableApplicationContext applicationContext;


    public int reduceTries(){
        return MAX_TRIES--;
    }

    public int getRemainingTries(){
        return MAX_TRIES;
    }

    public void resetTries(){
        MAX_TRIES = 5;
    }

    public GameService getGameService(){
        return applicationContext.getBean(GameService.class);
    }
}
