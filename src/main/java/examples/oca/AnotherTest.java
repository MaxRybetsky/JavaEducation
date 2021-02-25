package examples.oca;

public class AnotherTest {
    public int n = 0;

    {
        System.out.println(n);
        n++;
    }

    public static void main(String[] args) {
        AnotherTest test = new AnotherTest();
        test.inc();
        System.out.println(test.n);
    }

    public void inc() {
        n++;
    }

    {
        System.out.println(n);
    }
}

class A {
    static {
        add(2);
    }

    static void add(int num) {
        System.out.println(num + " ");
    }

    A() {
        add(5);
    }

    static {
        add(4);
    }

    {
        add(6);
    }

    static {
        new A();
    }

    {
        add(8);
    }

    static {
        add(10);
    }

    static {
        new A();
    }

    static {
        add(12);
    }

    public static void main(String[] args) {
    }
}
