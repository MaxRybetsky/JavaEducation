package algo.chapter6;

public class TriangleApp {
    public static void main(String[] args) {
        System.out.println(triangle(7));
    }

    public static int triangle(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + triangle(n - 1);
        }
    }
}
