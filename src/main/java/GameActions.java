import java.util.Random;
import java.util.Scanner;

public class GameActions {
    private Board board;
    private boolean player1Turn = true;


    public GameActions(Board board) {
        this.board = board;
    }

    public int makeMove(Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(player.getName() + "'s turn. Enter a square number (1-9): ");
        int squareNum = scanner.nextInt();

        // Check for valid input
        while (isValidMove(squareNum)) {
            System.out.print("Invalid move :( Enter a square number (1-9): ");
            squareNum = scanner.nextInt();
        }

        return squareNum;
    }

    public int makeCpuMove(ComputerPlayer computerPlayer) {
        int squareNum;
        Random rand = new Random();
        do {
            squareNum = rand.nextInt(9) + 1;
        } while (!isValidMove(squareNum));
        return squareNum;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    private boolean isValidMove(int squareNum) {
        return squareNum < 1 || squareNum > 9 || !isSquareEmpty(squareNum);
    }

    public boolean isSquareEmpty(int squareNum) {
        return board.getBoardField(squareNum-1).equals(String.valueOf(squareNum));
    }

    public void updateBoard(int squareNum, String marker) {
        board.setBoardField(squareNum-1, marker);
    }

    public boolean isGameOver() {
        return getWinner() != null || isDraw();
    }

    public boolean isDraw() {
        for (int i = 0; i < 9; i++) {
            if (board.getBoardField(i).equals(String.valueOf(i+1))) {
                return false;
            }
        }
        return true;
    }

    public String getWinner() {
        String winner = null;
        for (int[] condition : board.getWinConditions()) {
            String line = board.getBoardField(condition[0]) + board.getBoardField(condition[1]) + board.getBoardField(condition[2]);
            if (line.equals("XXX")) {
                winner = "X";
                break;
            }
            else if (line.equals("OOO")) {
                winner = "O";
                break;
            }
        }
        return winner;
    }


    public void reset() {
        for (int i = 0; i < 9; i++) {
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
