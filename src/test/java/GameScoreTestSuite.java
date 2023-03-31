import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameScoreTestSuite {
    private GameScore gameScore;

    @BeforeEach
    public void setUp() {
        gameScore = new GameScore(0, 0, 0, 0, null);
    }

    @Test
    public void addWinTest() {
        gameScore.addWin();
        Assertions.assertEquals(1, gameScore.getWins());
    }
    @Test
    public void addLossTest() {
        gameScore.addLoss();
        Assertions.assertEquals(1, gameScore.getLosses());
    }

    @Test
    public void addTieTest() {
        gameScore.addTie();
        Assertions.assertEquals(1, gameScore.getTies());
    }

    @Test
    public void incrementTotalGamesTest() {
        gameScore.incrementTotalGames();
        Assertions.assertEquals(1, gameScore.getTotalGames());
    }

    @Test
    public void updateLastGameTimestampTest() {
        gameScore.updateLastGameTimestamp();
        Assertions.assertNotNull(gameScore.getLastGame());
    }
}

