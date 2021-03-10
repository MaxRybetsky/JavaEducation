package examples.regex;

import java.util.Arrays;

public class RegexTest {
    public static void main(String[] args) {
        String s = "Привет";
        String[] letters = {"У"};
        StringBuilder regexS = new StringBuilder();
        regexS.append("\\b[");
        Arrays.stream(letters).forEach(letter -> {
            regexS.append(letter.toUpperCase());
            regexS.append(letter.toLowerCase());
        });
        regexS.append("][a-zA-Zа-яА-Я]*");
        String regex = regexS.toString();
        System.out.println(s.matches(regex));
        System.out.println("привет".matches(regex));
        System.out.println("уривет".matches(regex));
    }
}
