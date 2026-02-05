package at.technikum.flipper.input;

public class Button {

    protected final InputMediator mediator;

    public Button(InputMediator inputMediator) {
        this.mediator = inputMediator;
    }

    public void wasJustPressed() {
        this.mediator.notifyOfPress(this);
    }
    public void wasJustReleased() {
        this.mediator.notifyOfRelease(this);
    }

}
