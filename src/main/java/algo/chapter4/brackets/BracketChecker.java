package algo.chapter4.brackets;

import algo.chapter4.stack.StackChar;

public class BracketChecker {

    private final String input;

    public BracketChecker(String input) {
        this.input = input;
    }

    public boolean check() {
        int stackSize = input.length();
        StackChar stack = new StackChar(stackSize);
        for (int j = 0; j < stackSize; j++) {
            char ch = input.charAt(j);
            switch (ch) {
                case '{':
                case '[':
                case '(':
                    stack.push(ch);
                    break;
                case '}':
                case ']':
                case ')':
                    if (!stack.isEmpty()) {
                        char chx = stack.pop();
                        if ((ch == '}' && chx != '{')
                                || (ch == ']' && chx != '[')
                                || (ch == ')' && chx != '(')) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}

