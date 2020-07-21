package exam.lists;

import java.util.LinkedList;
import java.util.List;

public class Parentheses {
    public static boolean valid(char[] data) {
        List<Character> brackets = new LinkedList<>();
        int index = 0;
        boolean hasOpenBracket = false;
        for (char datum : data) {
            if (datum == '(') {
                brackets.add(datum);
                index++;
                hasOpenBracket = true;
            } else {
                if (hasOpenBracket) {
                    brackets.remove(--index);
                } else {
                    return false;
                }
            }
        }
        return brackets.size() == 0;
    }
}