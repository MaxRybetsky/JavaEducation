package examples.testing;

import org.junit.Test;

import static org.junit.Assert.*;

public class NetworkUtilsTest {
    @Test(timeout = 1000)
    public void getConnectionShouldReturnFasterThanOneSecond() {
        NetworkUtils.getConnection(false);
    }
}