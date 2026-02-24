package at.technikum.flipper.structureetal;

public interface Component {
    default Compositum getCompositum() {
        return null;
    }
}
