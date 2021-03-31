package exam.epam;

public class Third {
    public static void main(String[] args) {
        new A().log();
    }
}

interface I1{
    void m1();
    default void log() {
        System.out.println("I1");
    }
}

interface I2{
    void m2();
    default void log() {
        System.out.println("I2");
    }
}

class A implements I1, I2 {

    @Override
    public void m1() {

    }

    @Override
    public void log() {
        System.out.println("I1 + I2");
    }

    @Override
    public void m2() {

    }
}
