class Board {
    private String[] board;
    private int size;
    private int winLength;
    private final int[][] winConditions;

    public Board(int size, int winLength) {
        board = new String[(int) Math.pow(size,2)];
        this.size = size;
        this.winLength = winLength;
        for (int i = 0; i < Math.pow(size,2); i++) {
            board[i] = String.valueOf(i+1);
        }
        winConditions = WinConditionsCalculator.countWinConditions(size,winLength);
    }

    public String getBoardField(int index) {
        return board[index];
    }

    public void setBoardField(int index, String value) {
        board[index] = value;
    }
    public int[][] getWinConditions() {
        return winConditions;
    }

    public int getSize() {
        return size;
    }

    public int getSizeSquared() { return size * size; }

    public int getWinLength() {
        return winLength;
    }
}