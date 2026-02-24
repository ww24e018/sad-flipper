package at.technikum.flipper.structureetal;

import java.util.ArrayList;
import java.util.List;

public class DebugNoSuchCompositum implements Compositum{

    private final List<Component> components = new ArrayList<>();
    private final String name;

    public DebugNoSuchCompositum(String name) {
        this.name = name;
    }
    public String toString(){
        return String.format("%s %s","DebugNoSuchCompositum: ", this.name);
    }

    @Override
    public Compositum addComponent(Component component) {
        components.add(component);
        return this;
    }

    @Override
    public List<Component> getChildren() {
        return this.components;
    }

    @Override
    public void accept(ComponentVisitor visitor) {
        visitor.visit(this);
    }
}
