package it.marcodemartino.hangmanpattern.commands;

import it.marcodemartino.hangmanpattern.game.Hangman;

public class GuessLetterCommand implements Command {

    private final char letter;
    private final Hangman hangman;

    public GuessLetterCommand(char letter, Hangman hangman) {
        this.letter = letter;
        this.hangman = hangman;
    }


    @Override
    public void execute() {
        hangman.guessLetter(letter);
    }

    @Override
    public void undo() {
        hangman.unguessLetter(letter);
    }
}
