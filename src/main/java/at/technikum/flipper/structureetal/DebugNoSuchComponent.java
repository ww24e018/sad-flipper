package at.technikum.flipper.structureetal;

/**
 * An implementation of Component with the purpose of testing
 * the related visitor and compositum architecture.
 * No pinball-related functionality.
 */
public class DebugNoSuchComponent implements Component {

    private final String name;
    public DebugNoSuchComponent(String name) {
        this.name = name;
    }

    public String toString() {
        return String.format("%s %s","DebugNoSuchComponent: ", this.name);
    }

    @Override
    public void accept(ComponentVisitor visitor) {
        visitor.visit(this);
    }
}
