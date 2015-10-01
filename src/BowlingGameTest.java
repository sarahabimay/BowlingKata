import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BowlingGameTest {
    private BowlingGame g;
    @Before
    public void setUp(){
        g = new BowlingGame();
    }
    private void rollMany(int rolls, int pins) {
        for(int i = 0; i < rolls; ++i ) {
            g.roll(pins);
        }
    }
    @Test
    public void testGutterGame(){
        int rolls = 20;
        int pins = 0;
        rollMany(rolls, pins);
        assertEquals(0, g.score());
    }

    @Test
    public void testAllOnesGame(){
        rollMany(20, 1);
        assertEquals(20, g.score());
    }
    @Test
    public void testSpareGame(){
        rollSpare();
        g.roll(3);
        rollMany(17, 0);
        assertEquals(16, g.score());
    }

    private void rollSpare() {
        g.roll(5);
        g.roll(5);
    }
}