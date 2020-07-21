package exam.lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Parentheses {
    public static boolean valid(char[] data) {
        List<Character> brackets = new LinkedList<>();
        boolean hasOpenBracket = false;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == '(') {
                brackets.add(data[i]);
                hasOpenBracket = true;
            } else {
                if (hasOpenBracket) {
                    brackets.remove(i - 1);
                } else {
                    return false;
                }
            }
        }
        return brackets.size() == 0;
    }
}