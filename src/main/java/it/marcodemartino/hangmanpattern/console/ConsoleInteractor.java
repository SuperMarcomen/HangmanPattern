package it.marcodemartino.hangmanpattern.console;

import it.marcodemartino.hangmanpattern.commands.Command;
import it.marcodemartino.hangmanpattern.commands.CommandExecutor;
import it.marcodemartino.hangmanpattern.factory.CommandFactory;
import it.marcodemartino.hangmanpattern.factory.GuessLetterCommandFactory;
import it.marcodemartino.hangmanpattern.game.Hangman;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleInteractor {

    private final Map<String, CommandFactory> commandsFactories;
    private final CommandExecutor commandExecutor;
    private final Hangman hangman;

    public ConsoleInteractor() {
        commandExecutor = new CommandExecutor();
        hangman = new Hangman("hello");
        commandsFactories = new HashMap<>();
        commandsFactories.put("guess", new GuessLetterCommandFactory(hangman));
        runGame();
    }

    private void runGame() {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (!input.equals("quit")) {
            System.out.println("Word to guess: " + hangman.getHiddenWord());
            input = scanner.nextLine();
            handleCommand(input);
        }
    }

    private void handleCommand(String input) {
        if (input.equals("fuck")) {
            undo();
            return;
        }
        String[] cmdArgs = input.split(" ");
        CommandFactory factory = commandsFactories.get(cmdArgs[0]);
        if (factory == null) {
            System.out.println("Command not recognized");
            return;
        }
        Command command = factory.create(input);
        commandExecutor.execute(command);
    }

    private void undo() {
        commandExecutor.undoLastCommand();
    }


    public static void main(String[] args) {
        new ConsoleInteractor();
    }

}
