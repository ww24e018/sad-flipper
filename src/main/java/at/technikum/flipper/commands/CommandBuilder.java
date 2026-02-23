package at.technikum.flipper.commands;

public interface CommandBuilder extends Command {
    CommandBuilder add(Command command);
}
