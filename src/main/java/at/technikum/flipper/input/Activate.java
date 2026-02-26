package at.technikum.flipper.input;

import at.technikum.flipper.commands.Command;

public class Activate implements Command {

    private final Actuator actuator;

    public Activate(Actuator actuator) {
        this.actuator = actuator;
    }
    @Override
    public void execute() {
        this.actuator.activate();
    }
}
