package algo.chapter4.expressions;

public class InToPost {
    private StackX<Character> stack;
    private String input;
    private StringBuilder output = new StringBuilder();

    public InToPost(String input) {
        this.input = input;
        stack = new StackX<Character>(this.input.length());
    }

    public String doTrans() {
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            stack.displayStack("For " + ch);
            switch (ch) {
                case '+':
                case '-':
                    gotOper(ch, 1);
                    break;
                case '*':
                case '/':
                    gotOper(ch, 2);
                    break;
                case '(':
                    stack.push(ch);
                    break;
                case ')':
                    gotParen(ch);
                    break;
                default:
                    output.append(ch);
                    break;
            }
        }
        while (!stack.isEmpty()) {
            stack.displayStack("While");
            output.append(stack.pop());
        }
        stack.displayStack("End");
        return output.toString();
    }

    private void gotOper(char opThis, int prec1) {
        while (!stack.isEmpty()) {
            char opTop = stack.pop();
            if (opTop == '(') {
                stack.push(opTop);
                break;
            } else {
                int prec2 = opTop == '+' || opTop == '-' ? 1 : 2;
                if (prec2 < prec1) {
                    stack.push(opTop);
                    break;
                } else {
                    output.append(opTop);
                }
            }
        }
        stack.push(opThis);
    }

    private void gotParen(char ch) {
        while (!stack.isEmpty()) {
            char chx = stack.pop();
            if (chx == '(') {
                break;
            } else {
                output.append(chx);
            }
        }
    }
}
