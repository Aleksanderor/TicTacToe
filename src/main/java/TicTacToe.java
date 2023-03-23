public class TicTacToe {

    private final Board board;
    private Console console;
    private GameConfig gameConfig;
    private GameActions gameActions;
    private Player player1;
    private Player player2;
    private PlayerStats playerStats;

    public TicTacToe() {
        console = new Console();
        board = new Board(3);
        gameActions = new GameActions(board, gameConfig);
        gameConfig  = new GameConfig();
        playerStats = new PlayerStats();

    }

    public void startCvsP(){

        PlayerStats playerStats1;
        gameConfig.collectPlayerVsCpuData();

        while (!gameActions.isGameOver()) {
            handleGameProgressPvsCpu();
        }

        console.display(board);
        handleGameFinished();
        playAgain();
    }
    // start player vs player
    public void startPvsP() {

        gameConfig.collectPlayersData();

        while (!gameActions.isGameOver()) {
            handleGameProgressPvsP();
        }

        console.display(board);
        handleGameFinished();
        playAgain();
    }

    private void handleGameFinished() {
        String winner = gameActions.getWinner();
        if (winner != null) {
            console.print("Congratulations, " + winner + "! You have won the game!");
            Player winningPlayer = gameConfig.getPlayerByMarker(winner);
            playerStats.addWin(winningPlayer);
            Player losingPlayer = gameConfig.getPlayerByMarker(winningPlayer.getMarker().equals("X") ? "O" : "X");
            playerStats.addLoss(losingPlayer);
        } else {
            console.print("It's a draw!");
            playerStats.addTie(gameConfig.getPlayer1());
            playerStats.addTie(gameConfig.getPlayer2());
        }
    }

    private void handleGameProgressPvsP() {
        console.display(board);
        Player currentPlayer = gameActions.isPlayer1Turn() ? gameConfig.getPlayer1() : gameConfig.getPlayer2();
        int squareNum = gameActions.makeMove(currentPlayer);
        String marker = currentPlayer.getMarker();
        gameActions.updateBoard(squareNum, marker);
        gameActions.changePlayerTurn();
    }

    private void handleGameProgressPvsCpu() {
        console.display(board);
        if (gameActions.isPlayer1Turn()) {
            int squareNum = gameActions.makeMove(gameConfig.getPlayer1());
            String marker = gameConfig.getPlayer1().getMarker();
            gameActions.updateBoard(squareNum, marker);
        } else {
            int squareNum = gameActions.makeCpuMove();
            String marker = gameConfig.getPlayer2().getMarker();
            gameActions.updateBoard(squareNum, marker);
        }
        gameActions.changePlayerTurn();
    }

    public void playAgain() {
        console.print("Do you want to play again? (Y/N)");
        String answer = console.readString().toUpperCase();
        while (!answer.equals("Y") && !answer.equals("N")) {
            console.print("Invalid input! Do you want to play again? (Y/N)");
            answer = console.readString().toUpperCase();
        }
        if (answer.equals("Y")) {
            gameActions.reset();
            startPvsP();
        } else {
            console.print("Thanks for playing!");
        }
    }
}