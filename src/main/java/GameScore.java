public class GameScore {

    private int wins;
    private int ties;
    private int losses;

    public GameScore(int wins, int ties, int losses){
        this.wins = wins;
        this.ties = ties;
        this.losses = losses;
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
}

