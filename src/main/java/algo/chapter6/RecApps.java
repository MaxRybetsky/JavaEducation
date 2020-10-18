package algo.chapter6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecApps {
    static char[] a = {'A', 'B', 'C', 'D', 'E'};
    static List<Character> s = new ArrayList<>();
    static int kk;

    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println(x + "^" + y + " = " + power(x, y));*/

        kk = 3;
        combi(5, kk, ' ');
    }

    public static int power(int x, int y) {
        if (y == 1) {
            return x;
        } else {
            int m = y % 2 == 0 ? 1 : x;
            return m * power(x * x, y / 2);
        }
    }

    public static void combi(int n, int k, char c) {
        if (c != ' ') {
            s.add(c);
            if(s.size() == kk) {
                System.out.println(s);
                s.remove(s.size() - 1);
            }
        }
        if (n == 0 || k == 0 || k > n) {
            return;
        }
        if (n == 1 && k == 1) {
            s.add(a[a.length - n]);
            System.out.println(s);

            return;
        }
        combi(n - 1, k - 1, a[a.length - n]);
        combi(n - 1, k, ' ');
    }
}
