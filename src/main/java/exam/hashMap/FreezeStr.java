package exam.hashMap;

import java.util.HashMap;
import java.util.Map;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        Map<Character, Integer> chrsMap = new HashMap<>();
        for(Character ch : left.toCharArray()) {
            chrsMap.merge(ch, 1, Integer::sum);
        }
        for(Character ch : right.toCharArray()) {
            int value = chrsMap.getOrDefault(ch, 0);
            if(value == 0) {
                return false;
            }
            chrsMap.put(ch, --value);
        }
        return true;
    }
}
