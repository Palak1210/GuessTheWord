package com.example.guesstheword.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Scope("prototype")
public class GameService {
    private final String randomChosenWord;
    private final String[] randomWords = {"believe","god","incredible","life","blessing","gratitude"};
    Random random = new Random();
    private char[] choosenWordChars;

    public GameService() {
        randomChosenWord = randomWords[random.nextInt(randomWords.length)];
        choosenWordChars = new char[randomChosenWord.length()];
//        System.out.println(randomChosenWord + "----------------------------------ChoosenWord");
    }

    public String getRandomWord() {
        String hiddenWord = "";

        for(char c : choosenWordChars){
            if(c == 0){
                hiddenWord += "_";
            }else{
                hiddenWord += c;
            }
            hiddenWord += ' ';
        }
        return hiddenWord ;
    }

    public boolean checkGuess(Character guessedChar){
        boolean found = false;
        if(Character.isAlphabetic(guessedChar)){
            guessedChar = Character.toLowerCase(guessedChar);
            for(int i = 0;i< randomChosenWord.length();i++){
                if(randomChosenWord.charAt(i) == guessedChar){
                    choosenWordChars[i] = guessedChar;
                    found = true;
                }
            }
        }

        return found;
    }
}
