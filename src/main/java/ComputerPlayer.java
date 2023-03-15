import java.util.Random;

public class ComputerPlayer {

    private final String marker;
    private final String computerPlayer;

    public ComputerPlayer (String computerPlayer, String marker){

        this.marker = marker;
        this.computerPlayer = computerPlayer;
    }

    Random rand = new Random();
    int computerPlay = rand.nextInt(9) + 1;

    public String getComputerPlayer() {
        return computerPlayer;
    }

    //Wykonanie random ruchu
    //Sprawdzenie czy ruch jest możliwy
    //Sprawdzenie checkwin


}
