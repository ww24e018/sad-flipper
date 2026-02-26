package at.technikum.flipper.runstate;

import at.technikum.flipper.PinballMachine;
import at.technikum.flipper.commands.Command;
import at.technikum.flipper.commands.NoOpCommand;
import at.technikum.flipper.input.Button;
import at.technikum.flipper.input.ConsolePrintln;

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
    public void handleRightButtonPress() {
        System.out.println(".. nothing happens.");
    }

    @Override
    public void handleLeftButtonPress() {
        System.out.println(".. nothing happens.");
    }
}
