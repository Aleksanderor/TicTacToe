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

        // when
        gameScore.addWin();

        // then
        Assertions.assertEquals(1, gameScore.getWins());
    }
    @Test
    public void addLossTest() {

        // when
        gameScore.addLoss();

        // then
        Assertions.assertEquals(1, gameScore.getLosses());
    }

    @Test
    public void addTieTest() {

        // when
        gameScore.addTie();

        // then
        Assertions.assertEquals(1, gameScore.getTies());
    }

    @Test
    public void incrementTotalGamesTest() {

        // when
        gameScore.incrementTotalGames();

        // then
        Assertions.assertEquals(1, gameScore.getTotalGames());
    }

    @Test
    public void updateLastGameTimestampTest() {

        // when
        gameScore.updateLastGameTimestamp();

        // then
        Assertions.assertNotNull(gameScore.getLastGame());
    }
}

