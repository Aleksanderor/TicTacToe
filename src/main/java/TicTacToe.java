
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

    // start player vs player
    public void start() {
        console.print("Welcome to Tic Tac Toe!");
        gameConfig.collectPlayersData();

        while (!gameActions.isGameOver()) {
            handleGameProgress();
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

    private void handleGameProgress() {
        console.display(board);
        Player currentPlayer = gameActions.isPlayer1Turn() ? gameConfig.getPlayer1() : gameConfig.getPlayer2();
        int squareNum = gameActions.makeMove(currentPlayer);
        String marker = currentPlayer.getMarker();
        gameActions.updateBoard(squareNum, marker);
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
            start();
        } else {
            console.print("Thanks for playing!");
        }
    }
}