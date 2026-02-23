package at.technikum.flipper;

import at.technikum.flipper.commands.InvokeCarefullyCommand;
import at.technikum.flipper.commands.StandardCommandBuilder;
import at.technikum.flipper.input.SuperPinballMachine2000InputMediator;
import at.technikum.flipper.output.ascii.BannerFactoryFutureFont;

public class FL2kEntryTest {
    public static void main(String[] args) {
        var super2k = new SuperPinballMachine2000();
        var super2kInputMed = new SuperPinballMachine2000InputMediator(super2k);

        super2kInputMed.rightFlipperButton.wasJustPressed();
        super2kInputMed.leftFlipperButton.wasJustPressed();
        super2kInputMed.unusedButton.wasJustPressed();

        // var bannerFactory = new BannerFactoryGraffityFont();
        var bannerFactory = new BannerFactoryFutureFont();

        bannerFactory.CreatePressStart().print();
        bannerFactory.CreateGameOver().print();
        bannerFactory.CreateBall1().print();
        bannerFactory.CreateBall2().print();
        bannerFactory.CreateBall3().print();

        var printAllTheBanners = new StandardCommandBuilder();
               // .add()

    }
}
