package at.technikum.flipper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuperFlipper2000Test {

    @Test
    void superFlipperReportsAsSuperFlipper() {
        assertTrue(new SuperFlipper2000().getVersionString().toLowerCase().contains("superflipper"));
    }

}