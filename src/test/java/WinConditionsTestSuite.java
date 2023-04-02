import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class WinConditionsTestSuite {

    @Test
    public void countWinConditions3x3Test() {

        // given
        int size = 3;
        int winLength = 3;

        // when
        int[][] winConditions = WinConditionsCalculator.countWinConditions(size, winLength);

        // then
        int[][] expectedArray = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};
        assertArrayEquals(expectedArray, winConditions);
    }

    @Test
    public void countWinConditions4x4Test() {

        // given
        int size = 4;
        int winLenght = 4;

        // when
        int[][] winConditions = WinConditionsCalculator.countWinConditions(size, winLenght);

        // then
        int[][] expectedArray = {{0,1,2,3}, {4,5,6,7}, {8,9,10,11}, {12,13,14,15}, {0,4,8,12}, {1,5,9,13}, {2,6,10,14}, {3,7,11,15}, {0,5,10,15}, {3,6,9,12}};
        assertArrayEquals(expectedArray, WinConditionsCalculator.countWinConditions(4, 4));
    }

}