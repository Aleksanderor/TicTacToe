import java.util.Scanner;

class Player {
    private final String name;
    private final String marker;

    GameConfig gameConfig;

    public Player(String name, String marker) {
        this.name = name;
        this.marker = marker;
    }

    public String getName() {
        return name;
    }

    public String getMarker() {
        return marker;
    }

    public Player getPlayerByMarker(String marker) {
        if (gameConfig.getPlayer1().getMarker().equals(marker)) {
            return gameConfig.getPlayer1();
        } else {
            return gameConfig.getPlayer2();
        }
    }
}

