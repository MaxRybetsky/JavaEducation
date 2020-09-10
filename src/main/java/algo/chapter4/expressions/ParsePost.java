package algo.chapter4.expressions;

public class ParsePost {
    private StackX<Integer> stack;
    private String input;

    public ParsePost(String input) {
        this.input = input;
    }

    public int doParse() {
        stack = new StackX<>(20);
        char ch;
        int j;
        int num1, num2, interAns;

        for (int i = 0; i < input.length(); i++) {
            ch = input.charAt(i);
            stack.displayStack("" + ch);
            if (ch >= '0' && ch <= '9') {
                stack.push((int) (ch - '0'));
            } else {
                num2 = stack.pop();
                num1 = stack.pop();
                switch(ch) {
                    case '+':
                        interAns = num1 + num2;
                        break;
                    case '-':
                        interAns = num1 - num2;
                        break;
                    case '*':
                        interAns = num1 * num2;
                        break;
                    case '/':
                        interAns = num1 / num2;
                        break;
                    default:
                        interAns = 0;
                        break;
                }
                stack.push(interAns);
            }
        }
        return stack.pop();
    }
}
