package at.technikum.flipper;

import at.technikum.flipper.commands.Command;
import at.technikum.flipper.commands.StandardCommandBuilder;
import at.technikum.flipper.input.SuperPinballMachine2000InputMediator;
import at.technikum.flipper.output.ascii.AbstractBannerFactory;
import at.technikum.flipper.output.ascii.BannerFactoryFutureFont;
import at.technikum.flipper.output.ascii.BannerFactoryGraffityFont;
import at.technikum.flipper.output.ascii.PrintAsciiArtCmd;
import at.technikum.flipper.structureetal.CapsLockComponentDecorator;
import at.technikum.flipper.structureetal.CompTreeTraversalVisitor;
import at.technikum.flipper.structureetal.DebugNoSuchComponent;
import at.technikum.flipper.structureetal.DebugNoSuchCompositum;

public class FL2kEntryTest {
    public static void main(String[] args) {
        var super2k = new SuperPinballMachine2000();
        var super2kInputMed = new SuperPinballMachine2000InputMediator(super2k);

        super2kInputMed.rightFlipperButton.wasJustPressed();
        super2kInputMed.leftFlipperButton.wasJustPressed();
        super2kInputMed.unusedButton.wasJustPressed();


        testPrintBanners(new BannerFactoryGraffityFont()).execute();
        testPrintBanners(new BannerFactoryFutureFont()).execute();

        unwiseCommandBuilding();

        firstCompTraversalTest();
        tryingTheUppercaseDecorator();

        // Now the runLoopSimulation starts

        super2k.runLoopSimulation();


    }

    private static void tryingTheUppercaseDecorator() {
        System.out.println("\nTrying the uppercase decorator");
        System.out.println("------------------------------");

        var component = new DebugNoSuchComponent("This Is A Text (Component)");
        var decoratedComponent = new CapsLockComponentDecorator(component);
        var compositum = new DebugNoSuchCompositum("This Is A Text (Compositum)")
                .addComponent(decoratedComponent)
                .addComponent(component);
        var decoratedCompositum = new CapsLockComponentDecorator(compositum);

        new CompTreeTraversalVisitor().visit(decoratedCompositum);
        new CompTreeTraversalVisitor().visit(compositum);


    }

    private static void firstCompTraversalTest() {
        var comp1 = new DebugNoSuchComponent("hello world");
        var comp2 = new DebugNoSuchComponent("hello world no2");
        var myFirstCompositum = new DebugNoSuchCompositum("myFirstCompositum")
                .addComponent(comp1)
                .addComponent(comp2);
        var myFirstVisitor = new CompTreeTraversalVisitor();

        System.out.println("Running Visitor for my first compositum:");
        System.out.println("----------------------------------------");
        myFirstVisitor.visit(myFirstCompositum);

        // well. this works. ofc it does.
        System.out.println("\n\nRunning Visitor for second (and of course awesome) compositum:");
        System.out.println("------------------------------------------------------------------");
        var mySecondCompositum = new DebugNoSuchCompositum("mySecondAndAwesomeCompositum")
                .addComponent(myFirstCompositum)
                .addComponent(myFirstCompositum);

        myFirstVisitor
                .resetThreadUnsafeIterationDepthCounter()
                .visit(mySecondCompositum);
    }

    private static Command testPrintBanners(AbstractBannerFactory bannerFactory) {
        return new StandardCommandBuilder()
                .add(new PrintAsciiArtCmd(bannerFactory.CreatePressStart()))
                .add(new PrintAsciiArtCmd(bannerFactory.CreateGameOver()))
                .add(new PrintAsciiArtCmd(bannerFactory.CreateBall1()))
                .add(new PrintAsciiArtCmd(bannerFactory.CreateBall2()))
                .add(new PrintAsciiArtCmd(bannerFactory.CreateBall3()))
                ;
    }

    private static void unwiseCommandBuilding() {

        var builderOne = new StandardCommandBuilder();
        var builderTwo = new StandardCommandBuilder();
        var builderThree = new StandardCommandBuilder();

        builderOne.add(builderTwo);
        builderTwo.add(builderThree);
        builderThree.add(builderOne);

        try {
            builderOne.execute();
        } catch (StackOverflowError error) {
            System.out.format("Stacktrace-size at termination of unwise.execute(): %d\n",
                    error.getStackTrace().length);
        }

    }

}
