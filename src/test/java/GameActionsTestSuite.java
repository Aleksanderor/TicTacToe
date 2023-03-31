import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        gameConfig = new GameConfig(console);
        gameActions = new GameActions(board, gameConfig);
    }

    @Test
    void makeMoveTest() {
        // Set up the initial state of the game
        board.setBoardField(0, "X");
        board.setBoardField(1, "O");
        board.setBoardField(2, "X");
        board.setBoardField(3, "O");
        board.setBoardField(4, "O");

       //gameActions.makeMove(5, "X");


        assertEquals("X", board.getBoardField(5));
    }

    @Test
    void isDrawTest() {

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
        assertTrue(gameActions.isDraw());
        gameActions.reset();
    }

    @Test
    void isGameOverTest() {

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

        assertTrue(gameActions.isGameOver());
        gameActions.reset();
        assertFalse(gameActions.isGameOver());
    }

    @Test
    void isValidMoveTest() {
        Assertions.assertTrue(gameActions.isValidMove(1, 3));
        Assertions.assertTrue(gameActions.isValidMove(9, 10));
        Assertions.assertFalse(gameActions.isValidMove(0, 3));
        board.setBoardField(0, "X");
        Assertions.assertFalse(gameActions.isValidMove(1, 3));
    }

    @Test
    void isSquareEmptyTest() {
        Assertions.assertTrue(gameActions.isSquareEmpty(1));
        board.setBoardField(0, "X");
        Assertions.assertFalse(gameActions.isSquareEmpty(1));
    }



}
