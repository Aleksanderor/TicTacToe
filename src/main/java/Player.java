import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

class Player implements Serializable {
    private  String name;
    private  String marker;

    GameConfig gameConfig;

    public Player() {
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }
}

