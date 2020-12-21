package examples.threads;

public class Test2 {
    private int counter;

    public static void main(String[] args) throws InterruptedException {
        Test2 test = new Test2();
        for (int i = 0; i < 100; i++) {
            test.doWork();
            test.counter = 0;
        }
    }

    public synchronized void increment() {
        counter++;
    }

    public void doWork() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment();
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment();
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(counter);
    }
}
