import java.util.Random;
import java.util.Scanner;

public class GameActions {
    private Board board;
    private boolean player1Turn = true;

    private GameConfig gameConfig;

    public GameActions(Board board, GameConfig gameConfig) {
        this.board = board;
        this.gameConfig = gameConfig;
    }

    public int getInt(Scanner sc){
        while(!sc.hasNextInt()) {
            System.out.print("Invalid move :( Enter a square number within the given boad :(");
            sc.next();
        }

        return sc.nextInt();
    }

    public int makeMove(Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(player.getName() + "'s turn. Enter a square number within the board size :) ");

        int squareNum = getInt(scanner);

        while (!isValidMove(squareNum, board.getSizeSquared())) {
            System.out.print("Invalid move :( Enter a square number within the given boad :(");
            squareNum = getInt(scanner);
        }

        return squareNum;
    }

    public int makeCpuMove() {
        int squareNum;
        Random rand = new Random();
        do {
            squareNum = rand.nextInt(board.getSizeSquared()); //+ 1;
        } while (!isValidMove(squareNum, board.getSizeSquared()));
        System.out.printf("Computer made move and selected %s \n", squareNum);
        return squareNum;
    }

    boolean isValidMove(int squareNum, int boardSize) {
        return squareNum >= 1 && squareNum <= boardSize && isSquareEmpty(squareNum);
    }

    public boolean isSquareEmpty(int squareNum) {
        return board.getBoardField(squareNum-1).equals(String.valueOf(squareNum));
    }

    public void updateBoard(int squareNum, String marker) {
        board.setBoardField(squareNum-1, marker);
    }

    public boolean isGameOver() {
        return getWinner(board.getWinLength()) != null || isDraw();
    }

    public boolean isDraw() {
        for (int i = 0; i < board.getSizeSquared(); i++) {
            if (board.getBoardField(i).equals(String.valueOf(i+1))) {
                return false;
            }
        }
        return true;
    }

    public Player getWinner(int winLength) {
        String marker = null;
        for (int[] condition : board.getWinConditions()) {
            StringBuilder line = new StringBuilder();
            for(int i = 0; i < winLength; i++){
                line.append(board.getBoardField(condition[i]));
            }

            if (line.toString().toLowerCase().equals("x".repeat(winLength))) {
                marker = "x";
                break;
            }
            else if (line.toString().toLowerCase().equals("o".repeat(winLength))) {
                marker = "o";
                break;
            }
        }
        return marker != null ? gameConfig.getPlayerByMarker(marker) : null;
    }

    public void reset() {
        player1Turn = true;
        for (int i = 0; i < Math.pow(board.getSize(), 2); i++) {
            board.setBoardField(i, String.valueOf(i+1));
        }
    }

    public boolean isPlayer1Turn() {
        return player1Turn;
    }

    public void changePlayerTurn(){
        this.player1Turn = !this.isPlayer1Turn();
    }

}