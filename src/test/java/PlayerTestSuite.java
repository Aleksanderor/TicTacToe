import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTestSuite {

    @Test
    public void testGetMarker() {
        Player player = new Player("Jerzy", "X");
        assertEquals("X", player.getMarker());
    }

    @Test
    public void testEquals() {
        Player player1 = new Player("olek", "X");
        Player player2 = new Player("olek", "O");
        Player player3 = new Player("tomek", "X");

        assertTrue(player1.equals(player2));
        assertFalse(player1.equals(player3));
    }

    @Test
    public void testGetName() {
        Player player = new Player("Jacek", "O");
        assertEquals("Jacek", player.getName());
    }
}
