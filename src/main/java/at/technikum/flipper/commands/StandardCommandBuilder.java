package at.technikum.flipper.commands;

import java.util.ArrayList;
import java.util.List;

public class StandardCommandBuilder implements CommandBuilder {

    private List<Command> commandList = new ArrayList<>();

    @Override
    public CommandBuilder add(Command command) {
        this.commandList.add(command);
        return this;
    }

    @Override
    public void execute() {
        this.commandList.forEach(Command::execute);
    }
}
