package examples.interfaces;

import java.util.Arrays;
import java.util.List;

public class Cl {
    public static void main(String[] args) {
        A a = new MyClass("A");
        B b = new MyClass("B");
        MyClass myClass = new MyClass("MyClass");
        List<? super A> lst = Arrays.asList(
                a, b, myClass
        );
        test(lst);
    }

    private static void test(List<? super B> lst) {
        for (Object el : lst) {
            System.out.println(el);
        }
    }
}
