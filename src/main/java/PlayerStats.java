import java.util.HashMap;
import java.util.Map;

public class PlayerStats {

    Console console;
    private Map<Player, GameScore> resultsMap;

    public PlayerStats() {
        resultsMap = new HashMap<>();
    }

    public void addWin(Player player) {
        if (!resultsMap.containsKey(player)) {
            resultsMap.put(player, new GameScore(1, 0, 0));
        } else {
            resultsMap.get(player).addWin();
        }
    }

    public void addTie(Player player) {
        if (!resultsMap.containsKey(player)) {
            resultsMap.put(player, new GameScore(0, 1, 0));
        } else {
            resultsMap.get(player).addTie();
        }
    }

    public void addLoss(Player player) {
        if (!resultsMap.containsKey(player)) {
            resultsMap.put(player, new GameScore(0, 0, 1));
        } else {
            resultsMap.get(player).addWin();
        }
    }

    public void printResults() {
        for (Map.Entry<Player, GameScore> entry : resultsMap.entrySet()) {
            Player player = entry.getKey();
            GameScore score = entry.getValue();
            console.print(player.getName() + " results:");
            console.print("Wins: " + score.getWins());
            console.print("Losses: " + score.getLosses());
            console.print("Ties: " + score.getTies());
        }
    }
}
