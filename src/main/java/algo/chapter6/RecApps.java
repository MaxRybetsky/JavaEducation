package algo.chapter6;

import java.util.Scanner;

public class RecApps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println(x + "^" + y + " = " + power(x, y));
    }

    public static int power(int x, int y) {
        if (y == 1) {
            return x;
        } else {
            int m = y % 2 == 0 ? 1 : x;
            return m * power(x * x, y / 2);
        }
    }
}
