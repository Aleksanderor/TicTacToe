import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class GameActionsTestSuite {
    private GameConfig gameConfig;
    private Board board;
    private GameActions gameActions;

    private Console console;

    @BeforeEach
    void setUp() {
        board = new Board(3,3);
        Console console = new Console();
        gameActions = new GameActions(board, gameConfig);
    }

    @Test
    void isDrawTest() {

        // given
        assertFalse(gameActions.isDraw());
        board.setBoardField(0, "X");
        board.setBoardField(1, "O");
        board.setBoardField(2, "X");
        board.setBoardField(3, "X");
        board.setBoardField(4, "O");
        board.setBoardField(5, "O");
        board.setBoardField(6, "O");
        board.setBoardField(7, "X");
        board.setBoardField(8, "X");

        // when
        assertTrue(gameActions.isDraw());

        // then
        gameActions.reset();
    }

    @Test
    public void getWinnerTest() {

        // given
        Player player1 = new Player("Player 1", "x");
        Player player2 = new Player("Player 2", "x");
        GameConfig gameConfig = Mockito.mock(GameConfig.class);
        Mockito.when(gameConfig.getPlayerByMarker("X")).thenReturn(player1);
        Mockito.when(gameConfig.getPlayerByMarker("O")).thenReturn(player2);
        Console console = Mockito.mock(Console.class);
        Board board = new Board(3, 3);
        GameActions gameActions = new GameActions(board, gameConfig);
        Player expectedWinner = gameConfig.getPlayerByMarker("x");
        board.setBoardField(0, "X");
        board.setBoardField(1, "X");
        board.setBoardField(2, "X");
        board.setBoardField(5, "O");
        board.setBoardField(3, "O");

        // when
        Player actualWinner = gameActions.getWinner(3);

        // then
        assertEquals(expectedWinner, actualWinner);
    }
    @Test
    void isGameOverTest() {

        // given
        GameActions gameActions = new GameActions(board, gameConfig);

        board.setBoardField(0, "X");
        board.setBoardField(1, "O");
        board.setBoardField(2, "X");
        board.setBoardField(3, "O");
        board.setBoardField(4, "O");
        board.setBoardField(5, "X");
        board.setBoardField(6, "X");
        board.setBoardField(7, "X");
        board.setBoardField(8, "O");

        // when
        boolean isGameOver = gameActions.isGameOver();

        // then
        assertTrue(isGameOver);
        gameActions.reset();
        assertFalse(gameActions.isGameOver());
    }

    @Test
    void isValidMoveTest() {

        // when
        boolean isValidBefore = gameActions.isValidMove(1, 3);
        boolean isValidAfter = gameActions.isValidMove(0, 3);
        boolean isValidBeforeOutOfRange = gameActions.isValidMove(9, 10);
        board.setBoardField(0, "X");
        boolean isValidAfterOutOfRange = gameActions.isValidMove(1, 3);

        // then
        assertTrue(isValidBefore);
        assertFalse(isValidAfter);
        assertTrue(isValidBeforeOutOfRange);
        assertFalse(isValidAfterOutOfRange);
    }

    @Test
    void isSquareEmptyTest() {

        // when
        boolean isSquareEmptyBefore = gameActions.isSquareEmpty(1);
        board.setBoardField(0, "X");
        boolean isSquareEmptyAfter = gameActions.isSquareEmpty(1);

        // then
        assertTrue(isSquareEmptyBefore);
        assertFalse(isSquareEmptyAfter);
    }
}
