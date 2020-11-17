package examples.types;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App2 {
    public static void main(String[] args) {
        String[] strs = {"1!2", "3!4"};
        Map<String, String> map = Stream.of(strs)
                .collect(Collectors.toMap(
                        key -> key.split("!")[0],
                        value -> value.split("!")[1]
                ));
        System.out.println(map);
    }
}
