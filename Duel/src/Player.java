

public class Player {
    final private String playerName;
    private int score;

    public Player(String playerName) {
        this.playerName = playerName;
        score = 0;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
