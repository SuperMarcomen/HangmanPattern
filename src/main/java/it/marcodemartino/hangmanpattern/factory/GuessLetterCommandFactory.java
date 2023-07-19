package it.marcodemartino.hangmanpattern.factory;

import it.marcodemartino.hangmanpattern.commands.Command;
import it.marcodemartino.hangmanpattern.commands.GuessLetterCommand;
import it.marcodemartino.hangmanpattern.game.Hangman;

public class GuessLetterCommandFactory implements CommandFactory {

    private final Hangman hangman;

    public GuessLetterCommandFactory(Hangman hangman) {
        this.hangman = hangman;
    }


    @Override
    public Command create(String input) {
        String[] args = input.split(" ");
        return new GuessLetterCommand(args[1].charAt(0), hangman);
    }
}
