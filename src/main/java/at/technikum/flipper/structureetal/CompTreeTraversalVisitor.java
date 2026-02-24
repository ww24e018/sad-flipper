package at.technikum.flipper.structureetal;

public class CompTreeTraversalVisitor implements ComponentVisitor{

    private int threadUnsafeIterationDepthCounter;

    public CompTreeTraversalVisitor resetThreadUnsafeIterationDepthCounter() {
        this.threadUnsafeIterationDepthCounter = 0;
        return this;
    }

    @Override
    public void visit(Component component) {
        var entranceDepth = this.threadUnsafeIterationDepthCounter;

        String formatString = String.format("%%%ds- %%s\n", entranceDepth*2+1); // might need an "if" for zero indent :/
        System.out.format(formatString, "", component.toString());

        var compositum = component.getCompositum();
        if (compositum != null) {
            this.threadUnsafeIterationDepthCounter++;
            compositum.getChildren().forEach(child -> child.accept(this));
            // no "--", reset happens at end of function
        }

        this.threadUnsafeIterationDepthCounter = entranceDepth;
    }

}
