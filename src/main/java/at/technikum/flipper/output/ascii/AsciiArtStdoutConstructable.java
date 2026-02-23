package at.technikum.flipper.output.ascii;

import java.util.Arrays;
import java.util.List;

public class AsciiArtStdoutConstructable implements AsciiArt {
    private final String lines;

    public AsciiArtStdoutConstructable(String lines) {
        this.lines = lines;
    }

    @Override
    public void print() {
        //lines.split("\n").stream().forEach(System.out::println);
        String[] splitLines = this.lines.split("\n");
        Arrays.stream(splitLines).forEach(System.out::println);
    }

    @Override
    public String getLines() {
        return this.lines;
    }
}
