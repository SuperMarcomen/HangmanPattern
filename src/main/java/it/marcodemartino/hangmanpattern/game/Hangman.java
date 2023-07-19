package it.marcodemartino.hangmanpattern;

import java.util.ArrayList;
import java.util.List;

public class Hangman {

    private final String word;
    private final List<Character> guessedLetters;

    public Hangman(String word) {
        this.word = word;
        this.guessedLetters = new ArrayList<>();
    }
}
