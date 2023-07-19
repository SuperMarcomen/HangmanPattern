package it.marcodemartino.hangmanpattern.game;

import it.marcodemartino.hangmanpattern.commands.CommandExecutor;
import it.marcodemartino.hangmanpattern.commands.GuessLetterCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HangmanTest {

    @Test
    void guessLetter() {
        Hangman hangman = new Hangman("hello");
        GuessLetterCommand guessLetterCommand = new GuessLetterCommand('l', hangman);
        CommandExecutor commandExecutor = new CommandExecutor();
        assertEquals("-----", hangman.getHiddenWord());
        commandExecutor.execute(guessLetterCommand);
        assertEquals("--ll-", hangman.getHiddenWord());
        commandExecutor.undoLastCommand();
        assertEquals("-----", hangman.getHiddenWord());
    }

    @Test
    void unguessLetter() {
    }
}