package at.technikum.flipper.commands;

public class Sleep implements Command {

    long ms = 0;
    public  Sleep(long ms) {
        this.ms = Math.min(ms, 200);
    }
    @Override
    public void execute() {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            // this is ok.
        }
    }
}
