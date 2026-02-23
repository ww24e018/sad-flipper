package at.technikum.flipper;

import at.technikum.flipper.commands.Command;
import at.technikum.flipper.commands.StandardCommandBuilder;
import at.technikum.flipper.input.SuperPinballMachine2000InputMediator;
import at.technikum.flipper.output.ascii.AbstractBannerFactory;
import at.technikum.flipper.output.ascii.BannerFactoryFutureFont;
import at.technikum.flipper.output.ascii.BannerFactoryGraffityFont;
import at.technikum.flipper.output.ascii.PrintAsciiArtCmd;

public class FL2kEntryTest {
    public static void main(String[] args) {
        var super2k = new SuperPinballMachine2000();
        var super2kInputMed = new SuperPinballMachine2000InputMediator(super2k);

        super2kInputMed.rightFlipperButton.wasJustPressed();
        super2kInputMed.leftFlipperButton.wasJustPressed();
        super2kInputMed.unusedButton.wasJustPressed();


        testPrintBanners(new BannerFactoryGraffityFont()).execute();
        testPrintBanners(new BannerFactoryFutureFont()).execute();

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
}
