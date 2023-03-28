import java.io.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class PlayerStats {

    Console console;
    private Map<String, GameScore> resultsMap;
    File savedHashMaps;

    public PlayerStats(Console console, File file) {
        resultsMap = new HashMap<>();
        this.console = console;
        this.savedHashMaps = file;
        loadMap();
    }

    public void addWin(String player) {
        if (!resultsMap.containsKey(player)) {
            resultsMap.put(player, new GameScore(1, 0, 0, 1, Timestamp.from(Instant.now())));
        } else {
            resultsMap.get(player).addWin();
            resultsMap.get(player).incrementTotalGames();
            resultsMap.get(player).updateLastGameTimestamp();
        }
    }

    public void addTie(String player) {
        if (!resultsMap.containsKey(player)) {
            resultsMap.put(player, new GameScore(0, 1, 0, 1, Timestamp.from(Instant.now())));
        } else {
            resultsMap.get(player).addTie();
            resultsMap.get(player).incrementTotalGames();
            resultsMap.get(player).updateLastGameTimestamp();
        }
    }

    public void addLoss(String player) {
        if (!resultsMap.containsKey(player)) {
            resultsMap.put(player, new GameScore(0, 0, 1, 1, Timestamp.from(Instant.now())));
        } else {
            resultsMap.get(player).addLoss();
            resultsMap.get(player).incrementTotalGames();
            resultsMap.get(player).updateLastGameTimestamp();
        }
    }

    public void printResults() {
        for (Map.Entry<String, GameScore> entry : resultsMap.entrySet()) {
            String name = entry.getKey();
            GameScore score = entry.getValue();
            console.print(name + " results:");
            console.print("Wins: " + score.getWins());
            console.print("Losses: " + score.getLosses());
            console.print("Ties: " + score.getTies());
            console.print("Total games: " + score.getTotalGames());
            console.print("Last game played: " + score.getLastGame());
        }
    }

    public void saveMap() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream(savedHashMaps));
            oos.writeObject(resultsMap);
            oos.close();
        } catch (Exception e) {
            System.out.println("Błąd podczas zapisu do pliku");
        }
    }

    private void loadMap() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(savedHashMaps));
            Object readMap = ois.readObject();
            if (readMap instanceof HashMap) {
                resultsMap.putAll((HashMap) readMap);
            }
            ois.close();
        } catch (Exception e) {
            System.out.println("Błąd podczas odczytu z pliku");
        }
    }
}
