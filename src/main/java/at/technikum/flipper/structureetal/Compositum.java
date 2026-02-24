package at.technikum.flipper.structureetal;

public interface Compositum extends Component {
    default Compositum getCompositum() {
        return this;
    }
}
