import java.io.File;

public class TicTacToe {
    File savedHashMaps = new File("ranking.list");
    private final Board board;
    private Console console;
    private GameConfig gameConfig;
    private final GameActions gameActions;
    private final PlayerStats playerStats;

    public TicTacToe() {
        console = new Console();
        board = new Board(4,3
        );
        gameConfig  = new GameConfig(console);
        gameActions = new GameActions(board, gameConfig);
        playerStats = new PlayerStats(console, savedHashMaps);
    }

    public void start(){
        console.print("Welcome to TicTacToe! :)");
        gameConfig.chooseOpponent();
        if (gameConfig.chooseOpponent.equals("P")) {
            gameConfig.setPvpMode(true);
            startPvsP();
        } else {
            gameConfig.setPvpMode(false);
            startCvsP();
        }
    }

    public void startCvsP(){
        gameConfig.collectPlayerVsCpuData();
        runNewCvPGame();
    }

    private void runNewCvPGame() {
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
        runNewPvPGame();
    }

    private void runNewPvPGame() {
        while (!gameActions.isGameOver()) {
            handleGameProgressPvsP();
        }

        console.display(board);
        handleGameFinished();
        playAgain();
    }

    private void handleGameFinished() {
        Player winner = gameActions.getWinner(board.getWinLength());
        if (winner != null) {
            console.print("Congratulations, " + winner.getName() + "! You have won the game!");
            playerStats.addWin(winner.getName());
            Player losingPlayer = gameConfig.getPlayer1().equals(winner) ? gameConfig.getPlayer2() : gameConfig.getPlayer1();
            playerStats.addLoss(losingPlayer.getName());
        } else {
            console.print("It's a draw!");
            playerStats.addTie(gameConfig.getPlayer1().getName());
            playerStats.addTie(gameConfig.getPlayer2().getName());
        }
        playerStats.saveMap();
        console.print("----- Results -----");
        playerStats.printResults();

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
            if (gameConfig.isPvpMode()) {
                runNewPvPGame();
            } else {
                runNewCvPGame();
            }
        } else {
            console.print("Thanks for playing!");
        }
    }
}