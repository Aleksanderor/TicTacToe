import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;

public class GameScore implements Serializable{

    private int wins;
    private int ties;
    private int losses;
    private int totalGames;
    private Timestamp lastGame;

    public GameScore(int wins, int ties, int losses, int totalGames, Timestamp lastGame) {
        this.wins = wins;
        this.ties = ties;
        this.losses = losses;
        this.totalGames = totalGames;
        this.lastGame = lastGame;
    }

    public int getWins() {
        return this.wins;
    }

    public int getLosses() {
        return this.losses;
    }

    public int getTies() {
        return this.ties;
    }

    public void addWin() {
        this.wins++;
    }

    public void addLoss() {
        this.losses++;
    }

    public void addTie() {
        this.ties++;
    }

    public int getTotalGames() {
        return totalGames;
    }

    public Timestamp getLastGame() {
        return lastGame;
    }

    public void incrementTotalGames() {
        this.totalGames++;
    }

    public void updateLastGameTimestamp() {
        this.lastGame = Timestamp.from(Instant.now());
    }
}

