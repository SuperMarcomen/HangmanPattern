package it.marcodemartino.hangmanpattern.commands;

import java.util.Stack;

public class CommandExecutor {

    private final Stack<Command> commands;

    public CommandExecutor() {
        commands = new Stack<>();
    }

    public void execute(Command command) {
        commands.push(command);
        command.execute();
    }

    public void undoLastCommand() {
        commands.pop().undo();
    }
}
