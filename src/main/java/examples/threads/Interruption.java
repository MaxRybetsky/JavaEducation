package examples.threads;

import java.util.Random;

public class Interruption {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                for (int i = 0; i < 1_000_000_000; i++) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        System.out.println("Thread was interrupted");
                        break;
                    }
//                    if (Thread.currentThread().isInterrupted()) {
//                        System.out.println("Thread was interrupted at " + i);
//                        break;
//                    }
                    Math.sin(random.nextDouble());
                }
            }
        });
        System.out.println("Start");
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
        thread.join();
        System.out.println("Finish");
    }
}
