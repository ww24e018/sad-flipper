package at.technikum.flipper;

public class Flipper {

    private static Flipper instance;

    private int score = 0;

    private Flipper() {
        Flipper.instance = this;
    }

    public static Flipper getInstance() {
        if (Flipper.instance == null) {
            Flipper.instance = new Flipper();
        }
        return Flipper.instance;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        System.out.format("imagine the display of the highscore changing to %d\n", score);
        this.score = score;
    }

    public void increaseScore(int scoreDelta) {
        System.out.format("imagine the number %d animated as an increase\n", scoreDelta);
        this.setScore(this.getScore()+scoreDelta);
    }

}
