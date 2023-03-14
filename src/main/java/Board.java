class Board {
    private String[] board;
    private int size;
    private final int[][] winConditions = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columns
            {0, 4, 8}, {2, 4, 6} // Diagonals
    };

    public Board(int size) {
        board = new String[(int) Math.pow(size,2)];
        this.size = size;
        for (int i = 0; i < Math.pow(size,2); i++) {
            board[i] = String.valueOf(i+1);
        }
    }

    public String getBoardField(int index) {
        return board[index];
    }

    public String setBoardField(int index, String value) {
        return board[index] = value;
    }

    public int[][] getWinConditions() {
        return winConditions;
    }

    public int getSize() {
        return size;
    }
}