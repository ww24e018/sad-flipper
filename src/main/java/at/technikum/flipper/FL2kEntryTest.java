package at.technikum.flipper;

import at.technikum.flipper.input.SuperPinballMachine2000InputMediator;

public class FL2kEntryTest {
    public static void main(String[] args) {
        var super2k = new SuperPinballMachine2000();
        var super2kInputMed = new SuperPinballMachine2000InputMediator(super2k);

        super2kInputMed.rightFlipperButton.wasJustPressed();
        super2kInputMed.leftFlipperButton.wasJustPressed();
        super2kInputMed.unusedButton.wasJustPressed();
    }
}
