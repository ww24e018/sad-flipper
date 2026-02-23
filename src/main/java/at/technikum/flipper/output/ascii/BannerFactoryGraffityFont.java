package at.technikum.flipper.output.ascii;


/**
 * created as per angabe via (example):
 * http://patorjk.com/software/taag/#p=display&f=Graffiti&t=Press+Start&x=none&v=4&h=4&w=80&we=false
 */
public class BannerFactoryGraffityFont implements AbstractBannerFactory{

    @Override
    public AsciiArt CreatePressStart() {
        return new AsciiArtStdoutConstructable("""
                __________                                  _________ __                 __  \s
                \\______   \\_______   ____   ______ ______  /   _____//  |______ ________/  |_\s
                 |     ___/\\_  __ \\_/ __ \\ /  ___//  ___/  \\_____  \\\\   __\\__  \\\\_  __ \\   __\\
                 |    |     |  | \\/\\  ___/ \\___ \\ \\___ \\   /        \\|  |  / __ \\|  | \\/|  | \s
                 |____|     |__|    \\___  >____  >____  > /_______  /|__| (____  /__|   |__| \s
                                        \\/     \\/     \\/          \\/           \\/            \s
                """);
    }

    @Override
    public AsciiArt CreateGameOver() {
        return new AsciiArtStdoutConstructable("""
                  ________                        ________                    \s
                 /  _____/_____    _____   ____   \\_____  \\___  __ ___________\s
                /   \\  ___\\__  \\  /     \\_/ __ \\   /   |   \\  \\/ // __ \\_  __ \\
                \\    \\_\\  \\/ __ \\|  Y Y  \\  ___/  /    |    \\   /\\  ___/|  | \\/
                 \\______  (____  /__|_|  /\\___  > \\_______  /\\_/  \\___  >__|  \s
                        \\/     \\/      \\/     \\/          \\/          \\/      \s
                """);
    }

    @Override
    public AsciiArt CreateBall1() {
        return new AsciiArtStdoutConstructable("""
                __________        .__  .__     ____\s
                \\______   \\_____  |  | |  |   /_   |
                 |    |  _/\\__  \\ |  | |  |    |   |
                 |    |   \\ / __ \\|  |_|  |__  |   |
                 |______  /(____  /____/____/  |___|
                        \\/      \\/                 \s
                """);
    }

    @Override
    public AsciiArt CreateBall2() {
        return new AsciiArtStdoutConstructable("""
                __________        .__  .__    ________ \s
                \\______   \\_____  |  | |  |   \\_____  \\\s
                 |    |  _/\\__  \\ |  | |  |    /  ____/\s
                 |    |   \\ / __ \\|  |_|  |__ /       \\\s
                 |______  /(____  /____/____/ \\_______ \\
                        \\/      \\/                    \\/
                """);
    }

    @Override
    public AsciiArt CreateBall3() {
        return new AsciiArtStdoutConstructable("""
                __________        .__  .__    ________ \s
                \\______   \\_____  |  | |  |   \\_____  \\\s
                 |    |  _/\\__  \\ |  | |  |     _(__  <\s
                 |    |   \\ / __ \\|  |_|  |__  /       \\
                 |______  /(____  /____/____/ /______  /
                        \\/      \\/                   \\/\s
                """);
    }
}
