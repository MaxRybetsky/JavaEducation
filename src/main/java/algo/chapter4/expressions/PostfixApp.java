package algo.chapter4.expressions;

import java.util.Scanner;

public class PostfixApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        InToPost trans = new InToPost(scan.nextLine());
        ParsePost parse = new ParsePost(trans.doTrans());
        System.out.println("Evaluates to " + parse.doParse());
    }
}
