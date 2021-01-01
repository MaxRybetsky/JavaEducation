package examples.innerclasses;

public class Electrocar {
    private int id;
    private static int test;

    private class Motor {
        public void startMotor() {
            System.out.println("Motor " + id + " is started...");
        }
    }

    public static class Battery {
        public void charge() {
            System.out.println("Battery is charging..." + test);
        }
    }

    public Electrocar(int id) {
        this.id = id;
    }

    public void start() {
        Motor motor = new Motor();
        motor.startMotor();
        int x = 1;
        class SomeClass {
            @Override
            public String toString() {
                return x + " " + id;
            }
        }
        SomeClass someClass = new SomeClass();
        test(someClass);
        System.out.println("Car #" + id + " started!");
    }

    private void test(Object obj) {
        System.out.println(obj);
    }
}
