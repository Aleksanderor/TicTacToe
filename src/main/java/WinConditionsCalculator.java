import java.util.ArrayList;
import java.util.List;

public class WinConditionsCalculator {
    public static int[][] countWinConditions(int boardSize, int winLength){
        List<List<Integer>> winConditions = new ArrayList<>();

// Sprawdzanie wierszy
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j <= boardSize - winLength; j++) {
                List<Integer> condition = new ArrayList<>();
                for (int k = 0; k < winLength; k++) {
                    condition.add(i * boardSize + j + k);
                }
                winConditions.add(condition);
            }
        }

// Sprawdzanie kolumn
        for (int i = 0; i <= boardSize - winLength; i++) {
            for (int j = 0; j < boardSize; j++) {
                List<Integer> condition = new ArrayList<>();
                for (int k = 0; k < winLength; k++) {
                    condition.add((i + k) * boardSize + j);
                }
                winConditions.add(condition);
            }
        }

// Sprawdzanie przekątnych \
        for (int i = 0; i <= boardSize - winLength; i++) {
            for (int j = 0; j <= boardSize - winLength; j++) {
                List<Integer> condition = new ArrayList<>();
                for (int k = 0; k < winLength; k++) {
                    condition.add((i + k) * boardSize + j + k);
                }
                winConditions.add(condition);
            }
        }

// Sprawdzanie przekątnych /
        for (int i = 0; i <= boardSize - winLength; i++) {
            for (int j = winLength - 1; j < boardSize; j++) {
                List<Integer> condition = new ArrayList<>();
                for (int k = 0; k < winLength; k++) {
                    condition.add((i + k) * boardSize + j - k);
                }
                winConditions.add(condition);
            }
        }
        return winConditions.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
    }
}
