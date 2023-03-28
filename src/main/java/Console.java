import java.util.Scanner;

class Console {
    private final Scanner scanner;

    public Console() {
        scanner = new Scanner(System.in);
    }

    public void print(String message) {
        System.out.println(message);
    }

    public String readString() {
        return scanner.nextLine();
    }

    public int readInt() {
        return scanner.nextInt();
    }

    public void display(Board board) {
        int index = 0;
        for(int i = 0; i < board.getSize(); i++){
            for (int j = 0; j < board.getSize(); j++){
                if(board.getBoardField(index).contains("X")){
                    System.out.print("XXX" +  "|");
                } else if(board.getBoardField(index).contains("O")){
                    System.out.print("OOO" +  "|");
                } else{
                    System.out.print(("000" + board.getBoardField(index)).substring(board.getBoardField(index).length()) +  "|");
                }
                index++;
            }
            print(generateNewLine(board.getSize()));
        }
    }

    private String generateNewLine(int size) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        for(int i = 0; i < size; i++){
            stringBuilder.append("---+");
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }
}