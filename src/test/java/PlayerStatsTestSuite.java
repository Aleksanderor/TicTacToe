import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerStatsTestSuite {

    Console console;
    File file;
    PlayerStats playerStats;

    @BeforeEach
    public void setUp() {
        Console console = new Console();
        File file = new File("test_results.dat");
        playerStats = new PlayerStats(console, file);
    }

    @Test
    public void addWinTest(){

        //given
        String playerName = "Monika";

        //when
        playerStats.addWin(playerName);

        //then
        assertEquals(1, playerStats.getResultsMap().get(playerName).getWins());
        assertEquals(0, playerStats.getResultsMap().get(playerName).getLosses());
        assertEquals(0, playerStats.getResultsMap().get(playerName).getTies());
        assertEquals(1, playerStats.getResultsMap().get(playerName).getTotalGames());

    }

    @Test
    public void addLossTest(){

        //given
        String playerName = "Zosia";

        //when
        playerStats.addLoss(playerName);

        //then
        assertEquals(0, playerStats.getResultsMap().get(playerName).getWins());
        assertEquals(1, playerStats.getResultsMap().get(playerName).getLosses());
        assertEquals(0, playerStats.getResultsMap().get(playerName).getTies());
        assertEquals(1, playerStats.getResultsMap().get(playerName).getTotalGames());

    }

    @Test
    public void addTieTest(){
        String playerName = "Marcin";
        playerStats.addTie(playerName);
        assertEquals(0, playerStats.getResultsMap().get(playerName).getWins());
        assertEquals(0, playerStats.getResultsMap().get(playerName).getLosses());
        assertEquals(1, playerStats.getResultsMap().get(playerName).getTies());
        assertEquals(1, playerStats.getResultsMap().get(playerName).getTotalGames());
    }

    @Test
    public void loadMap (){

        //given
        GameScore loadedGameScore = new GameScore(2, 1, 0, 3, null);
        playerStats.getResultsMap().put("Anna", loadedGameScore);
        playerStats.saveMap();

        //when
        playerStats.loadMap();

        //then
        assertTrue(playerStats.getResultsMap().containsKey("Anna"));
        GameScore resultGameScore = playerStats.getResultsMap().get("Anna");
        assertEquals(loadedGameScore.getWins(), resultGameScore.getWins());
        assertEquals(loadedGameScore.getLosses(), resultGameScore.getLosses());
        assertEquals(loadedGameScore.getTies(), resultGameScore.getTies());
        assertEquals(loadedGameScore.getTotalGames(), resultGameScore.getTotalGames());
    }

    @Test
    public void saveMapTest() throws IOException {

        //given
        Console console = new Console();
        File file = new File("save_test.dat");
        PlayerStats playerStats = new PlayerStats(console, file);
        playerStats.addWin("Olek");
        playerStats.addTie("Zosia");
        playerStats.addLoss("Tomek");
        int expectedSize = 3;

        //when
        playerStats.saveMap();
        playerStats = new PlayerStats(console, file);
        int actualSize = playerStats.getResultsMap().size();

        //then
        assertEquals(expectedSize, actualSize);
    }
}





