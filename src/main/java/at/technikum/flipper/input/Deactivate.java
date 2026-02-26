package at.technikum.flipper.input;

import at.technikum.flipper.commands.Command;

public class Deactivate implements Command {

    private final Actuator actuator;

    public Deactivate(Actuator actuator) {
        this.actuator = actuator;
    }
    @Override
    public void execute() {
        this.actuator.deactivate();
    }

}
