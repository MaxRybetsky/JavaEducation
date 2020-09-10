package algo.chapter4.brackets;

import java.util.Scanner;

public class BracketsApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BracketChecker checker = new BracketChecker(sc.nextLine());
        System.out.println(checker.check());
    }
}
