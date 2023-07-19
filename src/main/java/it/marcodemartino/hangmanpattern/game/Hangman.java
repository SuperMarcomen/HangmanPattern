package it.marcodemartino.hangmanpattern.game;

import java.util.LinkedList;
import java.util.List;

public class Hangman {

    private final String word;
    private final List<Character> guessedLetters;

    public Hangman(String word) {
        this.word = word;
        this.guessedLetters = new LinkedList<>();
    }

    public String getHiddenWord() {
        StringBuilder hiddenWord = new StringBuilder();
        for (char letterInWord : word.toCharArray()) {
            if (guessedLetters.contains(letterInWord)) hiddenWord.append(letterInWord);
            else hiddenWord.append("-");
        }
        return hiddenWord.toString();
    }

    public boolean guessLetter(char letter) {
        guessedLetters.add(letter);
        return word.contains(String.valueOf(letter).toLowerCase());
    }

    public void unguessLetter(char letter) {
        guessedLetters.remove(Character.valueOf(letter));
    }
}
