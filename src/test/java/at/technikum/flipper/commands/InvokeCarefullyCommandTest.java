package at.technikum.flipper.commands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvokeCarefullyCommandTest {

    @Test
    void executeShouldNotThrowIfNotSuchMethodConfig() {
        var cmd = new InvokeCarefullyCommand(new Object(), "doesnotexist", new Object());
        assertDoesNotThrow(() -> cmd.execute());
    }


}