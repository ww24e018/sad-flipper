package at.technikum.flipper.input;

import at.technikum.flipper.commands.Command;

public class ConsolePrintln implements Command {

    private final String string;
    public ConsolePrintln(String string) {
        this.string = string;
    }
    @Override
    public void execute() {
        System.out.println(string);
    }
}
