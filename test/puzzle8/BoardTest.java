package puzzle8;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BoardTest {
    @Test
    public void dimension() {
        int[][] blocks = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
        Board b = new Board(blocks);

        assertEquals(3, b.dimension());
    }

    @Test
    public void testHammingCount() {
        int[][] blocks = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
        Board b = new Board(blocks);

        assertEquals(8, b.hamming());
    }

    @Test
    public void testHammingCountForGoal() {
        int[][] blocks = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        Board b = new Board(blocks);

        assertEquals(0, b.hamming());
    }

    @Test
    public void testManhattanCountForGoal() {
        int[][] blocks = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        Board b = new Board(blocks);

        assertEquals(0, b.manhattan());
    }

    @Test
    public void testManhattanCount() {
        int[][] blocks = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
        Board b = new Board(blocks);

        assertEquals(12, b.manhattan());
    }

    @Test
    public void testGoalForGoal() {
        int[][] blocks = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        Board b = new Board(blocks);

        assertTrue(b.isGoal());
    }

    @Test
    public void testGoalForNonGoalBoard() {
        int[][] blocks = {{0, 1, 5}, {3, 4, 2}, {6, 7, 8}};
        Board b = new Board(blocks);

        assertFalse(b.isGoal());
    }

    @Test
    public void testAutoboxingAndEquals() {
        double a = 0.0;
        double b = -0.0;
        Double x = new Double(0.0);
        Double y = new Double(-0.0);

        assertTrue(a == b);
        assertFalse(x.equals(y));

    }
}