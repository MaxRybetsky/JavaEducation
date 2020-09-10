package algo.chapter4.expressions;

import java.util.Scanner;

public class InfixApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        InToPost trans = new InToPost(scan.nextLine());
        System.out.println("Postfix is " + trans.doTrans());
    }
}
