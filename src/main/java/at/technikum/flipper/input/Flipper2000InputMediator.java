package at.technikum.flipper.input;

import at.technikum.flipper.SuperFlipper2000;

public class Flipper2000InputMediator  {

    private final SuperFlipper2000 flipper;
    public final LeftFlipperButton leftFlipperButton;
    public final RightFlipperButton rightFlipperButton;

    public Flipper2000InputMediator(SuperFlipper2000 flipper) {
        this.flipper = flipper;
        this.leftFlipperButton = new LeftFlipperButton(this);
        this.rightFlipperButton = new RightFlipperButton(this);
    }

    public void notifyOfPress(LeftFlipperButton button) {
        System.out.format("fl2k - *left* fbp\n");
    }
    public void notifyOfPress(RightFlipperButton button) {
        System.out.format("fl2k - *right*  fbp\n");
    }


}
