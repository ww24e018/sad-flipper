package at.technikum.flipper;

import at.technikum.flipper.commands.Command;
import at.technikum.flipper.input.ActuatorComponent;
import at.technikum.flipper.input.LeftFlipperButton;
import at.technikum.flipper.input.RightFlipperButton;
import at.technikum.flipper.input.SimpleActuator;
import at.technikum.flipper.runstate.MachineRunState;
import at.technikum.flipper.runstate.NoCreditState;
import at.technikum.flipper.runstate.PlayingState;

import java.util.Scanner;

public class SuperPinballMachine2000 implements PinballMachine {

    public ActuatorComponent leftFlipperActuator;
    public ActuatorComponent rightFlipperActuator;

    public LeftFlipperButton leftFlipperButton = new LeftFlipperButton(this);
    public RightFlipperButton rightFlipperButton = new RightFlipperButton(this);

    public MachineRunState machineRunState;

    public SuperPinballMachine2000() {
        leftFlipperActuator = new SimpleActuator("left flipper");
        rightFlipperActuator = new SimpleActuator("right flipper");

        machineRunState = new NoCreditState(this);
    }


    public void notifyOfPress(LeftFlipperButton leftButton) {
        machineRunState.handleLeftButtonPress();
    }
    public void notifyOfPress(RightFlipperButton rightButton) {
        machineRunState.handleRightButtonPress();
    }

    public void runLoopSimulation() {
        boolean quit = false;
        String input;
        Scanner scanner = new Scanner(System.in);
        printHelp();
        while(!quit) {
            System.out.format("\nspm2kSim > ");
            input = scanner.nextLine();
            if(this.quitMatcher(input)) { quit = true; continue; }
            switch (input) {
                case "left", "l": leftFlipperButton.wasJustPressed(); break; // this means about 3 hops of indirection?
                case "right", "r": rightFlipperButton.wasJustPressed(); break;
                case "coin", "c": machineRunState.handleCoinInsertion(); break;
                case "help", "h": this.printHelp(); break;
            }
        }
    }

    void printHelp() {
        System.out.println("\n\ntry: c(oin), l(eft), r(ight), h(elp)");
    }

    private boolean quitMatcher(String string) {
        return string.equals("quit") ||
                string.equals("q");
    };


    @Override
    public void takeCoin() {
        System.out.println("The coin makes tinkling noises as it goes through a tunnel into the coin-container.");
        this.changeStateTo(new PlayingState(this));
    }

    @Override
    public void releaseCoin() {
        System.out.println("The coin comes out of the coin-output with a final-sounding 'plonk!'");
    }

    @Override
    public void changeStateTo(MachineRunState machineRunState) {
        this.machineRunState = machineRunState;
    }

    @Override
    public String getVersionString() {
        return "SuperFlipper2000 v2000.0.1; by Flippers (Inc.)";
    }

    @Override
    public ActuatorComponent getLeftFlipperActuator() {
        return  leftFlipperActuator;
    }

    @Override
    public ActuatorComponent getRightFlipperActuator() {
        return  rightFlipperActuator;
    }
}
