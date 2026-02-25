package at.technikum.flipper.structureetal;

import java.util.List;

/**
 * Base interface for a simple Component with child nodes.
 * Extends Component by
 * - a different default implementation of getCompositum (siehe Buch Seite 218)
 * - addComponent() and getChildren() methods
 */
public interface Compositum extends Component {
    default Compositum getCompositum() {
        return this;
    }

    Compositum addComponent(Component component); // expected to return this for a builder pattern
    List<Component> getChildren();

}
