package at.technikum.flipper;

import at.technikum.flipper.runstate.MachineRunState;

public class SuperPinballMachine2000 implements PinballMachine {

    @Override
    public void takeCoin() {
        System.out.println("The coin makes tinkling noises as it goes through a tunnel into the coin-container.");
    }

    @Override
    public void releaseCoin() {
        System.out.println("The coin comes out of the coin-output with a final-sounding 'plonk!'");
    }

    @Override
    public void changeStateTo(MachineRunState machineRunState) {

    }

    @Override
    public String getVersionString() {
        return "SuperFlipper2000 v2000.0.1; by Flippers (Inc.)";
    }
}
