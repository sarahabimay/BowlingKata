import Game.Game;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BowlingGameTest {
    private Game theGame;
    @Before
    public void setUp() throws Exception {
        theGame = new Game();
    }
    private void rollMany(int n, int pins) {
        for (int i=0; i<n; i++)
            theGame.roll(pins);
    }

    @Test
    public void testGutterGame() throws Exception {
        rollMany(20, 0);
        assertEquals(0, theGame.score());
    }

    @Test
    public void testAllOnes() throws Exception {
        rollMany(20, 1);
        assertEquals(20, theGame.score());

    }
    @Test
    public void testOneSpare() throws Exception {
        rollSpare();
        theGame.roll(3);
        rollMany(17,0);
        assertEquals(16, theGame.score());

    }

    @Test
    public void testOneStrike() throws Exception{
        rollStrike();
        theGame.roll(3);
        theGame.roll(4);
        rollMany(16, 0);
        assertEquals(24, theGame.score());
    }

    @Test
    public void testPerfectGame() throws Exception {
        rollMany(12,10);
        assertEquals(300, theGame.score());
    }

    private void rollStrike() {
        theGame.roll(10);
    }

    private void rollSpare() {
        theGame.roll(5);
        theGame.roll(5);
    }
}