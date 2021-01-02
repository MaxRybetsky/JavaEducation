package examples.testing;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyMathTest {
    @Test(expected = ArithmeticException.class)
    public void zeroDenominatorShouldThrowException() {
        MyMath.divide(15, 0);
    }
}