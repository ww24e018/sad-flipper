package at.technikum.flipper.structureetal;

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
