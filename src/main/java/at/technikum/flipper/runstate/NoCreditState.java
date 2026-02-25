package at.technikum.flipper.runstate;

import at.technikum.flipper.PinballMachine;
import at.technikum.flipper.commands.Command;
import at.technikum.flipper.commands.NoOpCommand;
import at.technikum.flipper.input.Button;

public class NoCreditState implements MachineRunState{

    private PinballMachine pinballMachine;

    public  NoCreditState(PinballMachine pinballMachine) {
        this.pinballMachine = pinballMachine;
    }

    @Override
    public Command handleCoinInsertion() {
        // all coins are one.
        //this.pinballMachine.addCredit();
        return null; //TODO; perhaps this.pinball
    }

    @Override
    public Command handleButtonPress(Button button) {
        // no credit means no movement
        return NoOpCommand.getInstance();
    }
}
