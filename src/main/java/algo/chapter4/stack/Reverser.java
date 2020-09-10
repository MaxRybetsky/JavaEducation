package algo.chapter4.stack;

public class Reverser {
    private final String input;

    public Reverser(String in) {
        input = in;
    }

    public String doRev() {
        int stackSize = input.length();
        StackChar stack = new StackChar(stackSize);
        for (int i = 0; i < stackSize; i++) {
            stack.push(input.charAt(i));
        }
        StringBuilder output = new StringBuilder();
        while(!stack.isEmpty()) {
            output.append(stack.pop());
        }
        return output.toString();
    }
}
