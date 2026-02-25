package at.technikum.flipper;

import at.technikum.flipper.runstate.MachineRunState;

public interface PinballMachine {

    void takeCoin();
    void releaseCoin();
    void changeStateTo(MachineRunState machineRunState);

    default  String getVersionString() {
        return "Flipper, by Flippers (Inc.)";
    }
}
