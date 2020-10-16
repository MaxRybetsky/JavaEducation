package algo.chapter6.stackTriangle2;

public class StackX {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public StackX(int maxSize) {
        this.maxSize = maxSize;
        stackArray = new int[this.maxSize];
        top = -1;
    }

    public void push(int p) {
        stackArray[++top] = p;
    }

    public int pop() {
        return stackArray[top--];
    }

    public int peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
