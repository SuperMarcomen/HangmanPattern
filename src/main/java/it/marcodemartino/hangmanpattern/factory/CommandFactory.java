package it.marcodemartino.hangmanpattern.factory;

import it.marcodemartino.hangmanpattern.commands.Command;

public interface CommandFactory {

    Command create(String input);
}
