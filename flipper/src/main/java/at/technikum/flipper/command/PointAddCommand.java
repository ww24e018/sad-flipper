package at.technikum.flipper.command;

import at.technikum.flipper.Flipper;

public class PointAddCommand implements Command {

    int increment;
    public PointAddCommand(int increment) {
        this.increment = increment;
    }

    @Override
    public void execute() {
        Flipper.getInstance().increaseScore(this.increment);
    }
}
