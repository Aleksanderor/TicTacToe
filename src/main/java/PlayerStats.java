import java.util.HashMap;
import java.util.Map;

public class PlayerStats {
    private Map<Player, Integer[]> resultsMap;

    public PlayerStats() {
        resultsMap = new HashMap<>();
    }

    public void addResult(Player player, int wins, int losses, int ties) {
        Integer[] results = {wins, losses, ties};
        resultsMap.put(player, results);
    }

    public void printResults() {
        for (Player player : resultsMap.keySet()) {
            System.out.println(player.getName() + " - Wins: " + resultsMap.get(player)[0]
                    + ", Losses: " + resultsMap.get(player)[1]
                    + ", Ties: " + resultsMap.get(player)[2]);
        }
    }
}
