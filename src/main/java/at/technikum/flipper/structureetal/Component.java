package at.technikum.flipper.structureetal;


/**
 * Base interface for visitor/compositum nodes
 */
public interface Component {
    default Compositum getCompositum() {
        return null;
    }
    void accept(ComponentVisitor visitor); // visitor pattern got merged in to the interface at some point

}
