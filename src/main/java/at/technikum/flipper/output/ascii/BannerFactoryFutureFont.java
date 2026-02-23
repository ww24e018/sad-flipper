package at.technikum.flipper.output.ascii;

public class BannerFactoryFutureFont implements AbstractBannerFactory{
    @Override
    public AsciiArt CreatePressStart() {
        return new AsciiArtStdoutConstructable("""
                ┏━┓┏━┓┏━╸┏━┓┏━┓   ┏━┓╺┳╸┏━┓┏━┓╺┳╸
                ┣━┛┣┳┛┣╸ ┗━┓┗━┓   ┗━┓ ┃ ┣━┫┣┳┛ ┃\s
                ╹  ╹┗╸┗━╸┗━┛┗━┛   ┗━┛ ╹ ╹ ╹╹┗╸ ╹\s
                """);
    }

    @Override
    public AsciiArt CreateGameOver() {
        return new AsciiArtStdoutConstructable("""
                ┏━╸┏━┓┏┳┓┏━╸   ┏━┓╻ ╻┏━╸┏━┓
                ┃╺┓┣━┫┃┃┃┣╸    ┃ ┃┃┏┛┣╸ ┣┳┛
                ┗━┛╹ ╹╹ ╹┗━╸   ┗━┛┗┛ ┗━╸╹┗╸
                """);
    }

    @Override
    public AsciiArt CreateBall1() {
        return new AsciiArtStdoutConstructable("""
                ┏┓ ┏━┓╻  ╻     ┏━┓┏┓╻┏━╸
                ┣┻┓┣━┫┃  ┃     ┃ ┃┃┗┫┣╸\s
                ┗━┛╹ ╹┗━╸┗━╸   ┗━┛╹ ╹┗━╸
                """);
    }

    @Override
    public AsciiArt CreateBall2() {
        return new AsciiArtStdoutConstructable("""
                ┏┓ ┏━┓╻  ╻     ╺┳╸╻ ╻┏━┓
                ┣┻┓┣━┫┃  ┃      ┃ ┃╻┃┃ ┃
                ┗━┛╹ ╹┗━╸┗━╸    ╹ ┗┻┛┗━┛
                """);
    }

    @Override
    public AsciiArt CreateBall3() {
        return new AsciiArtStdoutConstructable("""
                ┏┓ ┏━┓╻  ╻     ╺┳╸╻ ╻┏━┓┏━╸┏━╸
                ┣┻┓┣━┫┃  ┃      ┃ ┣━┫┣┳┛┣╸ ┣╸\s
                ┗━┛╹ ╹┗━╸┗━╸    ╹ ╹ ╹╹┗╸┗━╸┗━╸
                """);
    }
}
