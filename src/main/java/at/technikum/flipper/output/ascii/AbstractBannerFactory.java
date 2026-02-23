package at.technikum.flipper.output.ascii;

public interface AbstractBannerFactory {
    public AsciiArt CreatePressStart();
    public AsciiArt CreateGameOver();
    public AsciiArt CreateBall1();
    public AsciiArt CreateBall2();
    public AsciiArt CreateBall3();

}
