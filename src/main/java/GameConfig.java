public class GameConfig {
    private final Console console;
    private Player player1;
    private Player player2;

    public GameConfig() {
        this.console = new Console();
    }

    public void collectPlayersData(){
        console.print("Player 1, enter your name:");
        String player1Name = console.readString();
        console.print(player1Name + ", choose your marker (X or O):");
        String player1Marker = console.readString().toUpperCase();
        player1Marker = getCorrectMarker(player1Marker);
        player1 = new Player(player1Name, player1Marker);

        console.print("Player 2, enter your name:");
        String player2Name = console.readString();
        String player2Marker = player1Marker.equals("X") ? "O" : "X";
        player2 = new Player(player2Name, player2Marker);
    }

    private String getCorrectMarker(String player1Marker) {
        while (!player1Marker.equals("X") && !player1Marker.equals("O")) {
            console.print("Invalid marker! Choose X or O:");
            player1Marker = console.readString().toUpperCase();
        }
        return player1Marker;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}
