package examples.testing;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Vector2DTest {
    private final double EPS = 1e-9;
    private Vector2D v1;

    @Before
    public void createNewVector() {
        //action
        v1 = new Vector2D();
    }

    @Test
    public void newVectorShouldHaveZeroLength() {
        //assertion
        assertEquals(0, v1.length(), EPS);
    }

    @Test
    public void newVectorShouldHaveZeroX() {
        //assertion
        assertEquals(0, v1.getX(), EPS);
    }

    @Test
    public void newVectorShouldHaveZeroY() {
        //assertion
        assertEquals(0, v1.getY(), EPS);
    }

}