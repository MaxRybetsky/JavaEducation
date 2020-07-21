package examples.other;

public class MyClass {
    public static void main(String[] args) {
        A a = new C();
        a.meth();
        ((C)a).meth1();
    }
}
