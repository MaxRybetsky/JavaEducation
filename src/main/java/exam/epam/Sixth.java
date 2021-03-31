package exam.epam;

public class Sixth extends Thread {
    @Override
    public void run() {
        System.out.println("Running");
    }

    public static void main(String[] args) {
        Runnable r = new Sixth();
        Thread th = new Thread(r);
        th.run();
    }
}
