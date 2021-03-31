package exam.epam;

public class Fourth {
    public synchronized static void main(String[] args) {
        Thread th = new Thread() {
            public void run() {
                pong();
            }
        };
        th.run();
        System.out.println("Ping");
    }

    static synchronized void pong() {
        System.out.println("Pong");
    }
}
