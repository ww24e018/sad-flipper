package at.technikum.flipper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuperPinballMachine2000Test {

    @Test
    void superFlipperReportsAsSuperFlipper() {
        assertTrue(new SuperPinballMachine2000().getVersionString().toLowerCase().contains("superflipper"));
    }

}