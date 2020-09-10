package algo.chapter4.expressions;

public class StackX<T> {
    private final int maxSize;
    private final T[] stackArray;
    private int top;

    @SuppressWarnings("unchecked")
    public StackX(int s) {
        maxSize = s;
        stackArray = (T[])new Object[maxSize];
        top = -1;
    }

    public void push(T j) {
        stackArray[++top] = j;
    }

    public T pop() {
        return stackArray[top--];
    }

    public T peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public int size() {
        return top + 1;
    }

    public void displayStack(String s) {
        System.out.print(s + " ");
        System.out.print("Stack (bottom-->top): ");
        for (int i = 0; i < size(); i++) {
            System.out.print(peekN(i) + " ");
        }
        System.out.println();
    }

    private T peekN(int n) {
        return stackArray[n];
    }
}
