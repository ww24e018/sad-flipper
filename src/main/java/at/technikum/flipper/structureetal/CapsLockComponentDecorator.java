package at.technikum.flipper.structureetal;

/**
 * A test-of-principle decorator for components.
 * Changes the toString() representation of the wrapped component to UPPERCASE.
 */
public class CapsLockComponentDecorator implements Component{

    private final Component component;

    public CapsLockComponentDecorator(Component component) {
        this.component = component;
    }

    @Override
    public Compositum getCompositum() {
        return component.getCompositum();
    }

    @Override
    public void accept(ComponentVisitor visitor) {
        component.accept(visitor);
    }

    @Override
    public String toString() {
        return this.component.toString().toUpperCase();
    }



}
