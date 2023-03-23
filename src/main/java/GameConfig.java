public class GameConfig {
    private static final String COMPUTER_NAME = "computer";
    private final Console console;
    public String chooseOpponent;
    private Player player1;
    private Player player2;

    public PlayerStats playerStats;

    public GameConfig() {
        this.console = new Console();
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
        String player1Marker = console.readString().toUpperCase();
        player1Marker = getCorrectMarker(player1Marker);
        player1 = new Player(player1Name, player1Marker);

        console.print("Player 2, enter your name:");
        String player2Name = console.readString();
        String player2Marker = player1Marker.equals("X") ? "O" : "X";
        player2 = new Player(player2Name, player2Marker);


    }

    public void collectPlayerVsCpuData(){
        console.print("Player, enter your name");
        String playerName = console.readString();
        console.print(playerName + " choose your marker");
        String playerMarker = console.readString();
        player1 = new Player(playerName, playerMarker);
        player2 = new Player(COMPUTER_NAME, playerMarker.equals("X") ? "O" : "X");
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