import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class GameConfigTestSuite {

    private GameConfig gameConfig;

    @BeforeEach
    public void setUp() {
        gameConfig = new GameConfig(new Console());
    }

    @Test
    public void testGetPlayerByMarker() {
        // given
        Player player1 = new Player("Tomek", "X");
        Player player2 = new Player("Jacek", "O");
        GameConfig gameConfig = new GameConfig(new Console());
        gameConfig.player1 = player1;
        gameConfig.player2 = player2;

        // when
        Player actualPlayer1 = gameConfig.getPlayerByMarker("X");
        Player actualPlayer2 = gameConfig.getPlayerByMarker("O");

        // then
        assertEquals(player1, actualPlayer1);
        assertEquals(player2, actualPlayer2);
    }

    @Test
    public void testGetPlayerByMarkerWithValidMarker() {
        // given
        Player player1 = new Player("Tomek", "X");
        Player player2 = new Player("Jacek", "O");
        gameConfig = new GameConfig(new Console());
        gameConfig.player1 = player1;
        gameConfig.player2 = player2;

        // when
        Player result = gameConfig.getPlayerByMarker("O");

        // then
        assertEquals(player2, result);
    }
    @Test
    public void isPvpModeTest() {
        Console console = new Console();
        GameConfig gameConfig = new GameConfig(console);
        assertFalse(gameConfig.isPvpMode());
        gameConfig.setPvpMode(true);
        assertTrue(gameConfig.isPvpMode());
    }


    @Test
    void testSetPvpMode() {
        Console console = new Console();
        GameConfig gameConfig = new GameConfig(console);
        assertFalse(gameConfig.isPvpMode());

        gameConfig.setPvpMode(true);
        assertTrue(gameConfig.isPvpMode());

        gameConfig.setPvpMode(false);
        assertFalse(gameConfig.isPvpMode());
    }

}
