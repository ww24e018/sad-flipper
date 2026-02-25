package at.technikum.flipper.commands;

/**
 * NoOpCommands provides an unchangeable Command that does nothing.
 * Useful to avoid if(x==null) checks.
 */
public class NoOpCommand implements Command {
    @Override
    public void execute() {};

    private static NoOpCommand singletonInstance;
    public static NoOpCommand getInstance() {
        if (singletonInstance == null) {singletonInstance = new NoOpCommand();}
        return singletonInstance;
    }
}
