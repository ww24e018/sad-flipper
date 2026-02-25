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
    public void handleCoinInsertion() {
        // all coins are one. and give 3 credits.
        pinballMachine.takeCoin();
    }

    @Override
    public Command reactionToButtonPress(Button button) {
        // no credit means no movement
        return NoOpCommand.getInstance();
    }
}
