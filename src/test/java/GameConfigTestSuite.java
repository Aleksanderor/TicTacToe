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
    public void collectPlayerVsCpuDataTest() {
        Console console = mock(Console.class);
        when(console.readString()).thenReturn("Test");
        GameConfig gameConfig = new GameConfig(console);
        gameConfig.collectPlayerVsCpuData();
        assertNotNull(gameConfig.getPlayer1());
        assertNotNull(gameConfig.getPlayer2());
        assertFalse(gameConfig.getPlayer1().getName().isEmpty());
        assertEquals(gameConfig.getPlayer2().getName(), "computer");
    }

    @Test
    public void chooseOpponentComputerTest() {
        Console console = mock(Console.class);
        when(console.readString()).thenReturn("C");
        GameConfig gameConfig = new GameConfig(console);
        gameConfig.chooseOpponent();
        assertEquals("C", gameConfig.chooseOpponent);
    }

    @Test
    public void chooseOpponentPlayerTest() {
        Console console = mock(Console.class);
        when(console.readString()).thenReturn("P");
        GameConfig gameConfig = new GameConfig(console);
        gameConfig.chooseOpponent();
        assertEquals("P", gameConfig.chooseOpponent);
    }

    @Test
    public void collectPlayersDataTest() {

        //Given
        Console console = mock(Console.class);
        GameConfig gameConfig = new GameConfig(console);

        String player1Name = "Olek";
        String player1Marker = "O";
        String player2Name = "Marek";
        String expectedPlayer2Marker = "X";

        when(console.readString()).thenReturn(player1Name)
                .thenReturn(player1Marker)
                .thenReturn(player2Name);

        gameConfig.collectPlayersData();

        //Then
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
        Console console = mock(Console.class);
        GameConfig gameConfig = new GameConfig(console);
        assertFalse(gameConfig.isPvpMode());
        gameConfig.setPvpMode(true);
        assertTrue(gameConfig.isPvpMode());
    }
    @Test
    public void setPvpModeTest() {

        Console console = mock(Console.class);
        GameConfig gameConfig = new GameConfig(console);

        assertFalse(gameConfig.isPvpMode());

        gameConfig.setPvpMode(true);

        assertTrue(gameConfig.isPvpMode());
    }


}
