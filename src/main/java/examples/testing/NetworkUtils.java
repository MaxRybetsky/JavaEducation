package examples.testing;

public class NetworkUtils {
    public static void getConnection(boolean sleep) {
        // get connection
        if (sleep) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return;
    }
}
