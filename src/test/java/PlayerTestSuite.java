import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTestSuite {

    @Test
    void getMarkerTest() {

        // given
        Player player = new Player("Jerzy", "X");

        // when
        String marker = player.getMarker();

        // then
        assertEquals("X", marker);
    }

    @Test
    void playerEqualsTest() {

        // given
        Player player1 = new Player("olek", "X");
        Player player2 = new Player("olek", "O");
        Player player3 = new Player("tomek", "X");

        // when
        boolean equal = player1.equals(player2);
        boolean equal2 = player1.equals(player3);

        // then
        assertFalse(equal2);
        assertTrue(equal);
    }

    @Test
    void getNameTest() {

        // given
        Player player = new Player("Jacek", "O");

        // when
        String name = player.getName();

        // then t
        assertEquals("Jacek", name);
    }
}
