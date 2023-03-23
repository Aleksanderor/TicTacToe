public class TicTacToeRunner {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        GameConfig gameConfig = new GameConfig();
        Console console = new Console();

        console.print("Welcome to TicTacToe! :)");
        gameConfig.chooseOpponent();

        if (gameConfig.chooseOpponent.equals("P")) {
            game.startPvsP();
        } else {
            game.startCvsP();
        }

    }
}