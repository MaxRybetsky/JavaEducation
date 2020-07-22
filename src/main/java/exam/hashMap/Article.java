package exam.hashMap;

import java.util.HashMap;
import java.util.Map;

public class Article {
    public static boolean generateBy(String origin, String line) {
        Map<String, Integer> words = new HashMap<>();
        String regex = "[.,!?:; -\"()]";
        for (String word : origin.split(regex)) {
            if (!"".equals(word)) {
                words.merge(word.toLowerCase(), 1, Integer::sum);
            }
        }
        for (String word : line.split(regex)) {
            if(!"".equals(word)) {
                int value = words.getOrDefault(word.toLowerCase(), 0);
                if (value == 0) {
                    return false;
                }
                words.put(word, --value);
            }
        }
        return true;
    }
}

