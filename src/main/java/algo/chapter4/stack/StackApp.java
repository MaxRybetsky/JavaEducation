package algo.chapter4.stack;

public class StackApp {
    public static void main(String[] args) {
        Stack stack = new Stack(10);
        stack.push(20);
        stack.push(40);
        stack.push(60);
        stack.push(80);
        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
}
