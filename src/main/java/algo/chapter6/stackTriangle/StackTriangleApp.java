package algo.chapter6.stackTriangle;

import java.util.Scanner;

public class StackTriangleApp {
    static int theNumber;
    static int theAnswer;
    static StackX stack;
    static int codePart;
    static Params theseParams;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter: ");
        theNumber = sc.nextInt();
        recTriangle();
        System.out.println("Triangle = " + theAnswer);
    }

    public static void recTriangle() {
        stack = new StackX(10000);
        codePart = 1;
        while (!step()) {
        }
    }

    public static boolean step() {
        switch (codePart) {
            case 1:
                theseParams = new Params(theNumber, 6);
                stack.push(theseParams);
                codePart = 2;
                break;
            case 2:
                theseParams = stack.peek();
                if (theseParams.getN() == 1) {
                    theAnswer = 1;
                    codePart = 5;
                } else {
                    codePart = 3;
                }
                break;
            case 3:
                Params newParams = new Params(theseParams.getN() - 1, 4);
                stack.push(newParams);
                codePart = 2;
                break;
            case 4:
                theseParams = stack.peek();
                theAnswer += theseParams.getN();
                codePart = 5;
                break;
            case 5:
                theseParams = stack.pop();
                codePart = theseParams.getReturnAddress();
                break;
            case 6:
                return true;
        }
        return false;
    }
}
