package examples.reflexion;

public class InA {
    public static int m = 12;

    static {
        for (int i = 0; i < 12; i++) {
            System.out.println(m + i);
        }
    }
}
