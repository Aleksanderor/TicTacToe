import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GameConfigTestSuite {

    private GameConfig gameConfig;

    @BeforeEach
    public void setUp() {
        gameConfig = new GameConfig(new Console());
    }

    @Test
    public void getPlayerByMarkerTest() {

        // given
        Player player1 = new Player("Tomek", "X");
        Player player2 = new Player("Jacek", "O");
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
        gameConfig.player1 = player1;
        gameConfig.player2 = player2;

        // when
        Player result = gameConfig.getPlayerByMarker("O");

        // then
        assertEquals(player2, result);
    }

    @Test
    public void collectPlayerVsCpuDataTest() {

        // given
        Console console = mock(Console.class);
        when(console.readString()).thenReturn("Olek").thenReturn("X");
        GameConfig gameConfig = new GameConfig(console);

        // when
        gameConfig.collectPlayerVsCpuData();

        // then
        assertEquals("Olek", gameConfig.getPlayer1().getName());
        assertEquals("x", gameConfig.getPlayer1().getMarker());
        assertEquals("computer", gameConfig.getPlayer2().getName());
        assertEquals("O", gameConfig.getPlayer2().getMarker());
    }

    @Test
    public void chooseOpponentComputerTest() {

        // given
        Console console = mock(Console.class);
        when(console.readString()).thenReturn("C");
        GameConfig gameConfig = new GameConfig(console);

        // when
        gameConfig.chooseOpponent();

        // then
        assertEquals("C", gameConfig.chooseOpponent);
    }

    @Test
    public void chooseOpponentPlayerTest() {

        // given
        Console console = mock(Console.class);
        when(console.readString()).thenReturn("P");
        GameConfig gameConfig = new GameConfig(console);

        // when
        gameConfig.chooseOpponent();

        //then
        assertEquals("P", gameConfig.chooseOpponent);
    }

    @Test
    public void collectPlayersDataTest() {

        // given
        Console console = mock(Console.class);
        GameConfig gameConfig = new GameConfig(console);

        String player1Name = "Olek";
        String player1Marker = "o";
        String player2Name = "Marek";
        String expectedPlayer2Marker = "x";

        when(console.readString()).thenReturn(player1Name)
                .thenReturn(player1Marker)
                .thenReturn(player2Name);

        gameConfig.collectPlayersData();

        // then
        verify(console).print("Player 1, enter your name:");
        verify(console).print(player1Name + ", choose your marker (X or O):");
        verify(console).print("Player 2, enter your name:");

        assertEquals(player1Name, gameConfig.getPlayer1().getName());
        assertEquals(player1Marker, gameConfig.getPlayer1().getMarker());
        assertEquals(player2Name, gameConfig.getPlayer2().getName());
        assertEquals(expectedPlayer2Marker, gameConfig.getPlayer2().getMarker());
    }

    @Test
    public void isPvpModeTest () {

        // given
        Console console = mock(Console.class);
        GameConfig gameConfig = new GameConfig(console);
        assertFalse(gameConfig.isPvpMode());
        gameConfig.setPvpMode(true);

        // then
        assertTrue(gameConfig.isPvpMode());
    }
    @Test
    public void setPvpModeTest() {
        // given
        Console console = mock(Console.class);
        GameConfig gameConfig = new GameConfig(console);
        assertFalse(gameConfig.isPvpMode());

        // when
        gameConfig.setPvpMode(true);

        // then
        assertTrue(gameConfig.isPvpMode());
    }


}
