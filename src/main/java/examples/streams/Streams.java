package examples.streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Streams {
    public static void main(String[] args) {
        List<List<Integer>> lst = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );
        int res = lst.stream()
                        .flatMap(Collection::stream)
                        .filter((el) -> el % 2 == 0)
                        .findAny()
                        .orElse(0);
        System.out.println(res);
    }
}
