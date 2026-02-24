package at.technikum.flipper.structureetal;

import java.util.List;

public interface Compositum extends Component {
    default Compositum getCompositum() {
        return this;
    }

    // skip remove and change getChild(i) to getChildren
    Compositum addComponent(Component component); // expected to return this for a builder pattern
    List<Component> getChildren();

    // skip parent references because OMG.
}
