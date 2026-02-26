package at.technikum.flipper.input;

import at.technikum.flipper.commands.Command;
import at.technikum.flipper.commands.Sleep;
import at.technikum.flipper.commands.StandardCommandBuilder;
import at.technikum.flipper.structureetal.ComponentVisitor;

public class SimpleActuator implements ActuatorComponent {

    private final Command activateCommand;
    private final Command  deactivateCommand;

    public SimpleActuator(String whatWouldBeActuated) {
        activateCommand = new StandardCommandBuilder()
                .add(new ConsolePrintln(whatWouldBeActuated+" activated"))
                .add(new Sleep(200))
                .add(new ConsolePrintln(whatWouldBeActuated+" deactivated"))
                ;
        deactivateCommand = new StandardCommandBuilder()
                .add(new ConsolePrintln(whatWouldBeActuated+" deactivated"))
                ;
    }
    @Override
    public void activate() {
        activateCommand.execute();
    }

    @Override
    public void deactivate() {
        deactivateCommand.execute();
    }

    @Override
    public void accept(ComponentVisitor visitor) {
        visitor.visit(this);
    }
}
