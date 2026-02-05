package at.technikum.flipper.input;

public class RightFlipperButton extends Button {


    public RightFlipperButton(InputMediator inputMediator) {
        super(inputMediator);
    }

    @Override
    public void wasJustPressed() {
        this.mediator.notifyOfPress(this);
    }
    @Override
    public void wasJustReleased() {
        this.mediator.notifyOfRelease(this);
    }
}
