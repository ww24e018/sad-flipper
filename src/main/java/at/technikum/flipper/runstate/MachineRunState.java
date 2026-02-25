package at.technikum.flipper.runstate;

import at.technikum.flipper.commands.Command;
import at.technikum.flipper.input.Button;

public interface MachineRunState {
    void handleCoinInsertion();
    Command reactionToButtonPress(Button button);
}
