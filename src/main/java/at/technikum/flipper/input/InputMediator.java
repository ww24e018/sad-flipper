package at.technikum.flipper.input;

public interface InputMediator {

    public void notifyOfPress(Button sender);
    public void notifyOfRelease(Button sender);
}
