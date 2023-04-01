import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class WinConditionsTestSuite {

    @Test
    public void testCountWinConditions3x3() {
        int[][] expected = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};
        assertArrayEquals(expected, WinConditionsCalculator.countWinConditions(3, 3));
    }

    @Test
    public void testCountWinConditions4x4() {
        int[][] expected = {{0,1,2,3}, {4,5,6,7}, {8,9,10,11}, {12,13,14,15}, {0,4,8,12}, {1,5,9,13}, {2,6,10,14}, {3,7,11,15}, {0,5,10,15}, {3,6,9,12}};
        assertArrayEquals(expected, WinConditionsCalculator.countWinConditions(4, 4));
    }

}