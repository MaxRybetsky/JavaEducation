package algo.chapter6.stackTriangle2;

import java.util.Scanner;

public class StackTriangle2App {
    static int num;
    static int answer;
    static StackX stack;

    public static void main(String[] args) {
        System.out.println("Enter: ");
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        stackTriangle();
        System.out.println("Triangle = " + answer);
    }

    public static void stackTriangle() {
        stack = new StackX(10000);
        answer = 0;
        while(num > 0) {
            stack.push(num--);
        }
        while(!stack.isEmpty()) {
            answer += stack.pop();
        }
    }
}
