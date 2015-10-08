import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    private Game game;

    @Before
    public void setUp() throws Exception {
        game = new Game();
    }

    @Test
    public void allZeros() {
        int rolls = 20;
        int pins = 0;
        rollMany(rolls, pins);
        assertEquals(0, game.score());
    }

    @Test
    public void allOnes() {
        rollMany(20, 1);
        assertEquals(20, game.score());
    }

    @Test
    public void strike() {
        rollStrike(10);
        game.roll(3);
        game.roll(4);
        rollMany(16, 0);
        assertEquals(24, game.score());
    }

    @Test
    public void spare() {
        rollSpare();
        game.roll(4);
        rollMany(17, 0);
        assertEquals(18, game.score());
    }

    @Test
    public void perfect() {
        rollMany(12, 10);
        assertEquals(300, game.score());
    }

    private void rollSpare() {
        game.roll(5);
        game.roll(5);
    }

    private void rollStrike(int pins) {
        game.roll(pins);
    }

    private void rollMany(int rolls, int pins) {
        for (int i = 0; i < rolls; i++) {
            game.roll(pins);
        }
    }
}