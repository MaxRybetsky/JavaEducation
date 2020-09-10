package algo.chapter4.stack;

import java.util.Scanner;

public class ReverseApp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word = in.nextLine();
        Reverser re = new Reverser(word);
        System.out.println("Reversed: " + re.doRev());
    }
}
