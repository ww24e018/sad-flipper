package at.technikum.flipper.output.ascii;

import at.technikum.flipper.commands.Command;

public class PrintAsciiArtCmd implements Command {

    private final AsciiArt asciiArt;

    public PrintAsciiArtCmd(AsciiArt asciiArt) {
        this.asciiArt = asciiArt;
    }

    @Override
    public void execute() {
        this.asciiArt.print();
    }
}
