package at.technikum.flipper.structureetal;

public interface Component extends Visitable {
    default Compositum getCompositum() {
        return null;
    }
}
