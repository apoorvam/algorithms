import org.junit.Test;

import static org.junit.Assert.*;

public class QuickFindUFTest {

    @Test
    public void connected() {
        QuickFindUF qf = new QuickFindUF(5);

        qf.union(0, 4);

        assertTrue(qf.connected(0, 4));
        assertTrue(qf.connected(4, 0));
        assertFalse(qf.connected(1, 2));
        assertFalse(qf.connected(2, 1));
        assertFalse(qf.connected(3, 4));
        assertFalse(qf.connected(2, 3));
        assertTrue(qf.connected(0, 0));
    }

}