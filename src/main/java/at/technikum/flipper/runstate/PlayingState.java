package at.technikum.flipper.runstate;

import at.technikum.flipper.PinballMachine;
import at.technikum.flipper.commands.InvokeCarefullyCommand;

public class PlayingState implements MachineRunState{

    private PinballMachine pinballMachine;

    public  PlayingState(PinballMachine pinballMachine) {
        this.pinballMachine = pinballMachine;
    }

    @Override
    public void handleCoinInsertion() {
        pinballMachine.releaseCoin();
    }

    @Override
    public void handleRightButtonPress() {
        pinballMachine.getRightFlipperActuator().activate();
    }

    @Override
    public void handleLeftButtonPress() {
        pinballMachine.getLeftFlipperActuator().activate();

    }
}
