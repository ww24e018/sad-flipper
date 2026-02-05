package at.technikum.flipper.input;

import java.lang.reflect.Method;

public class Button {

    protected final InputMediator mediator;

    public Button(InputMediator inputMediator) {
        this.mediator = inputMediator;
    }

    public void wasJustPressed()  {
        var mediatorClazz = this.mediator.getClass();
        var selfClazz = this.getClass();
        Method handler;
        System.out.format("<Button>: mediatorClazz.toString = %s\n", mediatorClazz.toString());
        try {
            handler = mediatorClazz.getDeclaredMethod("notifyOfPress", selfClazz);
        } catch (NoSuchMethodException e) {
            handler = mediatorClazz.getDeclaredMethod("notifyOfPress", Button.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        handler.invoke(this);
        this.mediator.notifyOfPress(this);
    }
    public void wasJustReleased() {
        this.mediator.notifyOfRelease(this);
    }

}
