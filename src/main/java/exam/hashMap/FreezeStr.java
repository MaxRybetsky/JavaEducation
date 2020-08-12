package exam.hashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

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

    public static void main(String[] args) {
        Function<Integer, Integer> func = (a) -> a / 0;
        System.out.println(func.apply(1));
    }
}
