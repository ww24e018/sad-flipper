package at.technikum.flipper.input;

import at.technikum.flipper.commands.Command;
import at.technikum.flipper.commands.InvokeCarefullyCommand;

import java.lang.reflect.Method;

public class Button {

    protected final Object mediator;
    protected final Command onPressCommand;
    protected final Command onReleaseCommand;

    public Button(Object mediator) {
        this.mediator = mediator;
        this.onPressCommand = new InvokeCarefullyCommand(this.mediator, "notifyOfPress", this);
        this.onReleaseCommand = new InvokeCarefullyCommand(this.mediator, "notifyOfRelease", this);
    }

    public void wasJustPressed()  {
        this.onPressCommand.execute();
    }
    public void wasJustReleased() {
        this.onReleaseCommand.execute();
    }

}
