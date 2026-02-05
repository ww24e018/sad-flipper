package at.technikum.flipper.input;

import at.technikum.flipper.SuperPinballMachine2000;

public class SuperPinballMachine2000InputMediator {

    private final SuperPinballMachine2000 flipper;
    public final LeftFlipperButton leftFlipperButton;
    public final RightFlipperButton rightFlipperButton;

    public final UnusedButton unusedButton;

    public SuperPinballMachine2000InputMediator(SuperPinballMachine2000 flipper) {
        this.flipper = flipper;
        this.leftFlipperButton = new LeftFlipperButton(this);
        this.rightFlipperButton = new RightFlipperButton(this);
        this.unusedButton = new UnusedButton(this);
    }

    public void notifyOfPress(LeftFlipperButton button) {
        System.out.format("fl2k - *left* fbp\n");
    }
    public void notifyOfPress(RightFlipperButton button) {
        System.out.format("fl2k - *right*  fbp\n");
    }
    public void notifyOfPress(Button button) {
        System.out.format("an 'other' button was pressed. actual class: %s\n", button.getClass().toString());
    }


}
