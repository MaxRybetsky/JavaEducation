package examples.threads;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
        new Scanner(System.in).nextLine();
        thread.shutdown();
    }
}

class MyThread extends Thread {
    private volatile boolean running = true;

    @Override
    public void run() {
        while (running) {
            System.out.println("Hello!");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown() {
        running = false;
    }
}

