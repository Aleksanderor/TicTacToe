public class GameConfig {
    private static final String COMPUTER_NAME = "computer";
    private Console console;
    public String chooseOpponent;
    Player player1;
    Player player2;
    private boolean pvpMode;

    public GameConfig(Console console) {

        this.console = console;
    }

    public void chooseOpponent(){
        console.print("Would you like to play vs a Computer or a Player");
        String opponentChoice = console.readString().toUpperCase();

        while (!opponentChoice.equals("C") && !opponentChoice.equals("P")) {
            console.print("Invalid move, choose to play with Computer or Player");
            opponentChoice = console.readString().toUpperCase();
        }
        chooseOpponent = opponentChoice;
    }

    public void collectPlayersData(){
        console.print("Player 1, enter your name:");
        String player1Name = console.readString();
        console.print(player1Name + ", choose your marker (X or O):");
        String player1Marker = console.readString();
        player1Marker = getCorrectMarker(player1Marker);
        player1 = new Player(player1Name, player1Marker.toLowerCase());

        console.print("Player 2, enter your name:");
        String player2Name = console.readString();
        String player2Marker = player1Marker.toLowerCase().equals("x") ? "o" : "x";
        player2 = new Player(player2Name, player2Marker.toLowerCase());


    }

    public void collectPlayerVsCpuData(){
        console.print("Player, enter your name");
        String playerName = console.readString();
        console.print(playerName + " choose your marker");
        String playerMarker = getCorrectMarker(console.readString());
        player1 = new Player(playerName, playerMarker.toLowerCase());
        player2 = new Player(COMPUTER_NAME, playerMarker.toLowerCase().equals("x") ? "O" : "X");
    }

    private String getCorrectMarker(String player1Marker) {
        while (!player1Marker.toLowerCase().equals("x") && !player1Marker.toLowerCase().equals("o")) {
            console.print("Invalid marker! Choose X or O:");
            player1Marker = console.readString();
        }
        return player1Marker;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Player getPlayerByMarker(String marker) {
        if (player1.getMarker().equals(marker)) {
            return player1;
        } else if (player2.getMarker().equals(marker)) {
            return player2;
        } else {
            throw new IllegalArgumentException("Invalid marker: " + marker);
        }
    }

    public boolean isPvpMode() {
        return pvpMode;
    }

    public void setPvpMode(boolean pvpMode) {
        this.pvpMode = pvpMode;
    }


}