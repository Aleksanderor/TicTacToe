import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTestSuite {

    @Test
    void boardInitializationTest() {

        // given
        Board board = new Board(3, 3);

        // then
        for (int i = 0; i < 9; i++) {
            assertEquals(String.valueOf(i+1), board.getBoardField(i));
        }
        assertEquals(3, board.getSize());
        assertEquals(3, board.getWinLength());
        int[][] winConditions = board.getWinConditions();
        assertEquals(8, winConditions.length);
        int[][] expectedWinConditions = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                {0, 4, 8}, {2, 4, 6}
        };
        for (int i = 0; i < 8; i++) {
            assertArrayEquals(expectedWinConditions[i], winConditions[i]);
        }
    }
    @Test
    void boardFieldSettingTest() {

        // given
        Board board = new Board(3, 3);

        // when
        board.setBoardField(4, "X");

        // then
        assertEquals("X", board.getBoardField(4));
    }
}
