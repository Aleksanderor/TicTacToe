public class TicTacToe {
    private final Board board;
    private Console console;
    private GameConfig gameConfig;
    private GameActions gameActions;

    public TicTacToe() {
        console = new Console();
        board = new Board(3);
        gameActions = new GameActions(board);
        gameConfig  = new GameConfig();


//        console.print("Would you like to play with an opponent or against a computer? O/C");
//        String opponentChoice = console.readString().toUpperCase();

//        while (!opponentChoice.equals("O") && !opponentChoice.equals("C")) {
//            console.print("Invalid move! Choose an opponen oraz computer O/C");
//            opponentChoice = console.readString().toUpperCase();
//        }
//
//        if(opponentChoice.equals("O")){
//
//        }


    }

    public void startCvsP(){

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
        } else {
            console.print("It's a draw!");
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