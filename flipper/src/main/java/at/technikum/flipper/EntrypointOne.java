package at.technikum.flipper;

import at.technikum.flipper.command.PointAddCommand;

public class EntrypointOne {
    public static void main(String[] args) {
        System.out.format("hu.");
        Flipper myFlipper = Flipper.getInstance();

        new PointAddCommand(10_000).execute();
        (new PointAddCommand(10_000)).execute();

    }
}
